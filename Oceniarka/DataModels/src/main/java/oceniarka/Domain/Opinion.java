package oceniarka.Domain;

import oceniarka.framework.DateTruncator;

import java.util.Date;

/**
 * Created by Rafał on 2015-10-25.
 */
public class Opinion extends AbstractSqlObject {

    private Integer productId;

    private Integer userId;

    private Integer rating;

    private Integer upVotes;

    private Integer downVotes;

    private Date addDate;

    private String comment;

    public Opinion() {

    }


    public Opinion(Integer id, Integer productId, Integer userId, Integer rating, Integer upVotes, Integer downVotes,
            Date addDate, String comment) {
        super(id);
        this.productId = productId;
        this.userId = userId;
        this.rating = rating;

        this.upVotes = upVotes;
        this.downVotes = downVotes;
        this.addDate = addDate;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "productId=" + productId +
                ", userId=" + userId +
                ", rating=" + rating +
                ", upVotes=" + upVotes +
                ", downVotes=" + downVotes +
                ", addDate=" + addDate +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Opinion opinion = (Opinion) o;


        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(getProductId(), opinion.getProductId())
                .append(getUserId(), opinion.getUserId())
                .append(getRating(), opinion.getRating())
                .append(getUpVotes(), opinion.getUpVotes())
                .append(getDownVotes(), opinion.getDownVotes())
                .append(DateTruncator.trancuateMilliseconds(getAddDate()),
                        DateTruncator.trancuateMilliseconds((opinion.getAddDate())))
                .append(getComment(), opinion.getComment())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(getProductId())
                .append(getUserId())
                .append(getRating())
                .append(getUpVotes())
                .append(getDownVotes())
                .append(getAddDate())
                .append(getComment())
                .toHashCode();
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(Integer upVotes) {
        this.upVotes = upVotes;
    }

    public Integer getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(Integer downVotes) {
        this.downVotes = downVotes;
    }


}
