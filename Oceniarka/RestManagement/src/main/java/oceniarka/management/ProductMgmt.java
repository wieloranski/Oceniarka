package oceniarka.management;

import oceniarka.Domain.Product;
import oceniarka.Filters.ProductFilter;
import oceniarka.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by nikodem on 07.12.15.
 */
@Component
public class ProductMgmt extends AbstractMgmt<Product, ProductFilter> {

    @Autowired
    ProductMapper productMapper;

    @Override
    @PostConstruct
    public void setMapper() {
        mapper = productMapper;
        filter = new ProductFilter();
    }

}
