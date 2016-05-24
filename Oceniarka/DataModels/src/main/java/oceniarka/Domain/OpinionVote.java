package oceniarka.Domain;

import oceniarka.framework.DateTruncator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Created by eryk on 27.10.15.
 */
public class OpinionVote extends AbstractSqlObject {

    private Integer opinionId;

    private Integer upDown;

    private Date addDate;

    public OpinionVote() {

    }

    public OpinionVote(Integer opinionId, Integer upDown, Date addDate) {
        super();
        this.opinionId = opinionId;
        this.upDown = upDown;
        this.addDate = addDate;
    }

    public OpinionVote(Integer id) {
        super(id);
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return "OpinionVote{" +
                "opinionId=" + opinionId +
                ", upDown=" + upDown +
                ", addDate=" + addDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        OpinionVote that = (OpinionVote) o;

        return new EqualsBuilder()
                .append(getOpinionId(), that.getOpinionId())
                .append(getUpDown(), that.getUpDown())
                .append(DateTruncator.trancuateMilliseconds(addDate), DateTruncator.trancuateMilliseconds(that.addDate))
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getOpinionId())
                .append(getUpDown())
                .append(addDate)
                .toHashCode();
    }

    public Integer getOpinionId() {
        return opinionId;
    }

    public void setOpinionId(Integer opinionId) {
        this.opinionId = opinionId;
    }

    public Integer getUpDown() {
        return upDown;
    }

    public void setUpDown(Integer upDown) {
        this.upDown = upDown;
    }
}