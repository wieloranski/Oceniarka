package oceniarka.management;

import oceniarka.Domain.Product;
import oceniarka.Filters.ProductFilter;
import oceniarka.framework.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * Created by eryk on 06.12.15.
 */
public class ProductMapperTest extends AbstarctMapperTest<Product, ProductFilter> {

    @Autowired
    ProductMgmt productMgmt;


    @PostConstruct
    @Override
    public void setManager() {
        manager = productMgmt;
    }

    @Override
    public void beforeInsert() {

        defaultObject = new Product(null, 1, 1, "Cokolwiek");
        anotherDefaultObject = new Product(null, 2, 2, "inne cokolwiek");
        domainName = "Product";

        insertedList = Arrays.asList(new Product(null, 1, 1, "Kwiaty"), new Product(null, 2, 2, "Kwiaty"), new Product(null, 3, 3, "Kwiaty"), new Product(null, 3, 4, "Kwiaty"));
        filterExpectedSizeMap = Arrays.asList(new Pair<>(new ProductFilter(null, 1, 3, "Kwiaty"), 3), new Pair<>(new ProductFilter(3, null, null, "Kwiaty"), 2));
    }


}
