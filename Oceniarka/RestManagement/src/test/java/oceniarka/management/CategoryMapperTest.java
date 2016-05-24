package oceniarka.management;

import oceniarka.Domain.Category;
import oceniarka.Filters.CategoryFilter;
import oceniarka.framework.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

/**
 * Created by eryk on 10.11.15.
 */
public class CategoryMapperTest extends AbstarctMapperTest<Category, CategoryFilter> {

    @Autowired
    CategoryMgmt categoryMgmt;

    @PostConstruct
    @Override
    public void setManager() {
        manager = categoryMgmt;

    }

    @Override
    public void beforeInsert() {
        defaultObject = Example.DEFAULT_OBJECT.category;
        int id = categoryMgmt.selectNLastRecords(1).get(0).getId();

        anotherDefaultObject = new Category(id, "Instrumenty");

        insertedList = new ArrayList<>();
        insertedList.add(defaultObject);
        insertedList.add(new Category(1, "asd"));

        filterExpectedSizeMap = new ArrayList<>();
        filterExpectedSizeMap.add(new Pair<>(new CategoryFilter("Samochody", 1, 2), 1));
    }

    enum Example {

        DEFAULT_OBJECT(new Category(null, "Samochody"));


        private final Category category;

        Example(Category category) {
            this.category = category;
        }
    }

}
