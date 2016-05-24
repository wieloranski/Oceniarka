package oceniarka.Domain;

import com.google.common.base.Objects;

/**
 * Created by s396422 on 20.10.15.
 */
public class Category extends AbstractSqlObject {

    private Integer parent;

    private String name;

    public Category() {

    }

    public Category(Integer id) {
        super(id);
    }

    public Category(Integer parent, String name) {
        super();
        this.parent = parent;
        this.name = name;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "parent=" + parent +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equal(getParent(), category.getParent()) &&
                Objects.equal(getName(), category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getParent(), getName());
    }
}
