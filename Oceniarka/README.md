# Oceniarka

### Liquibase

Wyposażyłem aplikacje w database migration tool. Od teraz jeśli chcemy zmienić coś w bazie wrzucamy po prostu skrypt sql do katalogu sql w module RestManagement (niestety musi to być w tym module inaczej liquibase nie znajduje skryptów). Aplikacja pamięta, które skrypty wykonała i gdy pojawi się nowy wykonuje go podczas startu aplikacji, w ten sposób zachowujemy integralność pomiędzy tym co jest w bazie na każdym z komputerów i serwerze. 

Baza danych od której zaczynają się skrypty jest w module DataManagement pod nazwą "oceniarka.out", usunąłęm skrypt sql ponieważ był on już dawno nieaktualny, a niechciało mi się pisać nowego, który odwzorowywał by to co jest aktualnie na serwerze. Aby "zaimportować" u siebie (lokalnie) bazę należy zdropować aktualną, utworzyć pustą, a następnie wklepać.

``` sh
cd DataManagement/src/main/resources/
mysql -u oceniarka -p
drop database oceniarka;
create database oceniarka;
exit
mysql -u oceniarka -p oceniarka < oceniarka.out
```

Bardzo ważne jest by zrobić to przed pierwszym uruchomieniem aplikacji z liquibasem.

### Hasła

Pozmieniałem wszędzie gdzie się da hasła. Generalnie jeśli chodzi o dostęp do openshifta i jego repo warto sobie wrzucić tam swój klucz ssh wtedy pomijamy całe logowanie.

Opeshift.com/dostęp przez ssh  
**login:** dagi12@o2.pl  
**hasło:** oceniarka  

MySql  
**login:** oceniarka  
**hasło:** oceniarka  

PhpMyAdmin  
**login:** oceniarka  
**hasło:** oceniarka  

Serwer  
**login:** oceniarka  
**hasło:** oceniarka  

### Serwer - Inicjalizacja obsługi

Generalnie wszystkie komendy są w bashu pod linuxem, ale na Windowsie można sobie poradzić tak samo tylko będzie potrzebny PuTTy by połączyć się ssh z maszyną OpenShifta i GitBash do command-line'a (dla komend gita).

Aby wykonywać jakieś operacje na serwerze postawionym na http://oceniarka-oceniarka.rhcloud.com/ należy najpierw sobie sklonować repo openshifta. 
``` sh
git clone ssh://564aedb97628e16ba80000b9@oceniarka-oceniarka.rhcloud.com/~/git/oceniarka.git/
```
Następnie warto dodać nasze źródłowe repo jako repo matkę
``` sh
cd oceniarka
git remote add mother https://github.com/rafi94/Oceniarka.git
```
Oczywiście można by zrobić by repo openshifta i nasze było tym samym, ale jest to słabe rozwiązanie sczególnie jeśli są minimalne różnice w konfiguracji albo chemy trzymać na serwerze coś czego nie powinno być w repo i na odwrót, generalnie lepiej mieć dwa.  

### Serwer - korzystanie

Teraz żeby to co mamy na repo znalazło się na serwerze wystarczy w katalogu openshifta (na naszym PC) wykonać
``` sh
git pull mother master
git push origin master
```

Aby wejść na nasz serwer należy wpisać
``` sh
ssh 564aedb97628e16ba80000b9@oceniarka-oceniarka.rhcloud.com
```
Następnie, aby przejść do repo
``` sh
cd $OPENSHIFT_REPO_DIR
```
Tu znajdziemy skrypty, które umożliwiają odpalenie i zamknięcie serwera.

Jeśli serwer z jakiegoś powodu nie działa wywala 500, 404 czy cokolwiek to zazwyczaj wystarczy go zrestartować, w tym celu wchodzimy na serwer i wykonujemy skrypty.
``` sh
ssh 564aedb97628e16ba80000b9@oceniarka-oceniarka.rhcloud.com
cd $OPENSHIFT_REPO_DIR
./restart.sh
```
Załóżmy następujący scenariusz. Robimy zmiany lokalnie puszujemy na repo, potem synchronizujemy z repo openshifta, zamykamy aktualnie działający serwer, budujemy aplikacje mavenem i odpalamy serwer. Czyli w skrócie wrzucamy nasze zmiany na serwer. W tym celu należy wystarczy wykonać
``` sh
git pull mother master
git push origin master
```
Openshifta skonfigurowałem tak, by automatycznie po pushu zatrzymał, zbudował i uruchomił aplikację.

### MySql - serwer

Na serwer jest postawiona baza danych MySql, dostęp do niej można uzyskać poprzez zainstalowany phpMyAdmin pod adresem http://oceniarka-oceniarka.rhcloud.com/phpmyadmin

Jest to możliwe również poprzez aplikacje MySql Workbench osobiście preferuje to rozwiązanie.
W MySql Workbench należy skonfiguować połączenie w następujący sposób. Wchodzimy w Database -> Manage Connections
I ustawiamy następujące parametry

Connection Method: Standard TCP/IP over SSH
SSH Hostname: oceniarka-oceniarka.rhcloud.com
SSH Username: 564aedb97628e16ba80000b9
SSH Password: oceniarka
MySql Hostname: 127.4.44.2
MySql Port: 3306
Username: oceniarka
Password: oceniarka

Istnieje również możliwość przekopiowania swojej bazy na serwer i na odwrót, jest to lepsze rozwiązanie niż modyfikacja databasecheme.sql i tworzenie bazy na nowo.

Lokalnie -> Serwer

```sh
mysqldump -u <twoja nazwa użytkownika> -p oceniarka > oceniarka.out
scp oceniarka.out 564aedb97628e16ba80000b9@oceniarka-oceniarka.rhcloud.com:/var/lib/openshift/564aedb97628e16ba80000b9/mysql
ssh 564aedb97628e16ba80000b9@oceniarka-oceniarka.rhcloud.com
mysql -u oceniarka -p oceniarka < /var/lib/openshift/564aedb97628e16ba80000b9/mysql/oceniarka.out
```

Serwer -> Lokalnie

```sh
ssh 564aedb97628e16ba80000b9@oceniarka-oceniarka.rhcloud.com
mysqldump -u oceniarka -p oceniarka > /var/lib/openshift/564aedb97628e16ba80000b9/mysql/oceniarka.out
exit
scp 564aedb97628e16ba80000b9@oceniarka-oceniarka.rhcloud.com:/var/lib/openshift/564aedb97628e16ba80000b9/mysql oceniarka.out
mysql -u <twoja nazwa użytkownika> -p oceniarka < oceniarka.out
```

### Jenkins

Dostępny pod adresem https://jenkins-oceniarka.rhcloud.com/
login: admin
hasło: rf6GirPw21I4

Będą tu następujące joby
- restart
- synchronizacja z gitem i restart
- odpalenie testów

Ale jeszcze tego nie skminiłem

### Uruchomienie
Aby uruchomić projekt należy go najpierw pobrać np. poleceniem
``` sh
git clone https://github.com/rafi94/Oceniarka.git
```
Następnie wejść do glównego katalogu projektu i wykonac następujące polecenia Mavena
``` sh
mvn clean install
mvn -pl RestManagement spring-boot:run
```
Po chwili powinien odpalić się wbudowany Tomcatowy serwer. Aplikacja domyślnie odpala się pod adresem http://localhost:8080

### Autoryzacja
Aby uzyskać dostep do danych z API należy się zweryfikować. Do tego celów testowych można użyć testowego konta (oceniarka/oceniarka). Serwer do identyfikacji użytkowników używa metody "Basic authentication" (https://en.wikipedia.org/wiki/Basic_access_authentication) czyli w każdym żądaniu należy wysłac zakodowany login i hasło. Uzyskać go można poprzez wysłanie danych żądaniem POST na /api/session np.
``` sh
 curl -i -X POST -H "Content-Type: application/json" -d '{"email":"oceniarka", "password":"oceniarka"}' localhost:8080/api/session
```
W odpowiedzi dostaniemy JSON'a, który w polu AUTH będzie zawierał zakodowany ciąg znaków, który następnie należy wysyłać w każdym odwołaniu do API w nagłówku "Authorization: basic [AUTH]} np.
``` sh
curl -i -X GET -H "Authorization: Basic c29tZVVzZXJAc29tZU1haWwuY29tOnNvbWVQYXNzd29yZA==" localhost:8080/api/categories
```

### Dokumentacja
Projekt automatycznie generuję aktualną dokumentację REST API, aby ja przejrzeć należy najpierw włączyć projekt, następnie wejść na stronę
```sh
/v2/api-docs?group=OceniarkaAPI
```
Czyli dla standardowego adresu
```sh
http://localhost:8080/v2/api-docs?group=OceniarkaAPI
```
Z podanej strony należy przekopiować cały kod, a następnie wejść na stronę
```sh
http://editor.swagger.io/#/
```
Na tej stronie należy zmienić wejściowy format na JSON, aby to zrobić należy wejść w 
```sh
preferences>editor settings
```
I w opcji mode wybrać JSON. Następnie należy przekopiować uzyskany wcześniej kod do edytora. Po prawej stronie powinna pojawić się dokumentacja API
