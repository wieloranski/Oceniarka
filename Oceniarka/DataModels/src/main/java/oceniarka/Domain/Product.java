package oceniarka.Domain;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Created by Rafa� on 2015-10-25.
 */
public class Product extends AbstractSqlObject {

    private Integer categoryId;

    private Integer productRating;

    private String productName;

    public Product() {

    }

    public Product(Integer id, Integer categoryId, Integer productRating, String productName) {
        super(id);
        this.categoryId = categoryId;
        this.productRating = productRating;
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return new EqualsBuilder()
                .append(getCategoryId(), product.getCategoryId())
                .append(getProductRating(), product.getProductRating())
                .append(getProductName(), product.getProductName())
                .isEquals();
    }

    @Override
    public String toString() {
        return "Product{" +
                "categoryId=" + categoryId +
                ", productRating=" + productRating +
                ", productName='" + productName + '\'' +
                '}';
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }


    public Integer getProductRating() {
        return productRating;
    }

    public void setProductRating(Integer productRating) {
        this.productRating = productRating;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
