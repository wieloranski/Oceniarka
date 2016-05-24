package oceniarka.Domain;

/**
 * Created by eryk on 27.10.15.
 */
public enum UserType {

    USER(0),

    MODERATOR(1),

    ADMINISTRATOR(2);

    private Integer value;

    UserType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }


}
