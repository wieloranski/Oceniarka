package oceniarka.management;

import oceniarka.Domain.Category;
import oceniarka.Filters.CategoryFilter;
import oceniarka.mappers.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CategoryMgmt extends AbstractMgmt<Category, CategoryFilter> {

    @Autowired
    public CategoryMapper categoryMapper;

    @Override
    @PostConstruct
    public void setMapper() {
        mapper = categoryMapper;
        filter = new CategoryFilter();
    }

}
