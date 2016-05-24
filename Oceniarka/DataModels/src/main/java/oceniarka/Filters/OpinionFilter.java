package oceniarka.Filters;

import java.util.Date;

/**
 * Created by eryk on 03.11.15.
 */
public class OpinionFilter extends AbstractFilter {

    private Integer productId;

    private Integer userId;

    private Integer ratingFrom;

    private Integer ratingTo;

    private Integer upVotesFrom;

    private Integer upVotesTo;

    private Integer downVotesFrom;

    private Integer downVotesTo;

    private Date dateAddFrom;

    private Date dateAddTo;

    public OpinionFilter() {
        super();
    }

    public OpinionFilter(Integer productId, Integer userId, Integer ratingFrom, Integer ratingTo, Integer upVotesFrom, Integer upVotesTo, Integer downVotesFrom, Integer downVotesTo, Date dateAddFrom, Date dateAddTo) {
        this.productId = productId;
        this.userId = userId;
        this.ratingFrom = ratingFrom;
        this.ratingTo = ratingTo;
        this.upVotesFrom = upVotesFrom;
        this.upVotesTo = upVotesTo;
        this.downVotesFrom = downVotesFrom;
        this.downVotesTo = downVotesTo;
        this.dateAddFrom = dateAddFrom;
        this.dateAddTo = dateAddTo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getRatingFrom() {
        return ratingFrom;
    }

    public void setRatingFrom(Integer ratingFrom) {
        this.ratingFrom = ratingFrom;
    }

    public Integer getRatingTo() {
        return ratingTo;
    }

    public void setRatingTo(Integer ratingTo) {
        this.ratingTo = ratingTo;
    }

    public Integer getUpVotesFrom() {
        return upVotesFrom;
    }

    public void setUpVotesFrom(Integer upVotesFrom) {
        this.upVotesFrom = upVotesFrom;
    }

    public Integer getUpVotesTo() {
        return upVotesTo;
    }

    public void setUpVotesTo(Integer upVotesTo) {
        this.upVotesTo = upVotesTo;
    }

    public Integer getDownVotesFrom() {
        return downVotesFrom;
    }

    public void setDownVotesFrom(Integer downVotesFrom) {
        this.downVotesFrom = downVotesFrom;
    }

    public Integer getDownVotesTo() {
        return downVotesTo;
    }

    public void setDownVotesTo(Integer downVotesTo) {
        this.downVotesTo = downVotesTo;
    }

    public Date getDateAddFrom() {
        return dateAddFrom;
    }

    public void setDateAddFrom(Date dateAddFrom) {
        this.dateAddFrom = dateAddFrom;
    }

    public Date getDateAddTo() {
        return dateAddTo;
    }

    public void setDateAddTo(Date dateAddTo) {
        this.dateAddTo = dateAddTo;
    }

}