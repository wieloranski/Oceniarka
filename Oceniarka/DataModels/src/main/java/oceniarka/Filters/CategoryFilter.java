package oceniarka.Filters;

/**
 * Created by eryk on 03.11.15.
 */
public class CategoryFilter extends AbstractFilter {

    private Integer parentFrom;

    private Integer parentTo;

    private String name;

    public CategoryFilter() {
        super();
    }

    public CategoryFilter(String name, Integer parentFrom, Integer parentTo) {
        this.parentFrom = parentFrom;
        this.parentTo = parentTo;
        this.name = name;
    }

    public CategoryFilter(int id) {
        super(id);
    }

    public Integer getParentFrom() {
        return parentFrom;
    }

    public void setParentFrom(Integer parentFrom) {
        this.parentFrom = parentFrom;
    }

    public Integer getParentTo() {
        return parentTo;
    }

    public void setParentTo(Integer parentTo) {
        this.parentTo = parentTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
