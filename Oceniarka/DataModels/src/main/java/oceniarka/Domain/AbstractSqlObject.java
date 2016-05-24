package oceniarka.Domain;

/**
 * Created by eryk on 08.12.15.
 */
public class AbstractSqlObject {

    private Integer id;

    AbstractSqlObject(Integer id) {
        this.id = id;
    }

    AbstractSqlObject() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
