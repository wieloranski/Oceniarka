package oceniarka.Filters;

/**
 * Created by eryk on 03.11.15.
 */
public class ProductFilter extends AbstractFilter {

    private Integer categoryId;

    private Integer productRatingFrom;

    private Integer productRatingTo;

    private String productName;

    public ProductFilter() {
        super();
    }

    public ProductFilter(int id) {
        super(id);
    }

    public ProductFilter(Integer categoryId, Integer productRatingFrom, Integer productRatingTo, String productName) {
        this.categoryId = categoryId;
        this.productRatingFrom = productRatingFrom;
        this.productRatingTo = productRatingTo;
        this.productName = productName;
    }

    public Integer getProductRatingTo() {
        return productRatingTo;
    }

    public void setProductRatingTo(Integer productRatingTo) {
        this.productRatingTo = productRatingTo;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getProductRatingFrom() {
        return productRatingFrom;
    }

    public void setProductRatingFrom(Integer productRatingFrom) {
        this.productRatingFrom = productRatingFrom;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
