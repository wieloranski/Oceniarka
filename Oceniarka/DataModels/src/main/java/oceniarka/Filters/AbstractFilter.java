package oceniarka.Filters;

/**
 * Created by eryk on 08.12.15.
 */
public class AbstractFilter {

    private Integer id;

    AbstractFilter() {

    }

    AbstractFilter(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
