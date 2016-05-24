package oceniarka.Filters;

import java.util.Date;

/**
 * Created by eryk on 03.11.15.
 */
public class OpinionVoteFilter extends AbstractFilter {

    private Integer opinionId;

    private Integer upDownFrom;

    private Integer upDownTo;

    private Date addDateFrom;

    private Date addDateTo;

    public OpinionVoteFilter(Integer opinionId, Integer upDownFrom, Integer upDownTo, Date addDateFrom,
            Date addDateTo) {
        this.opinionId = opinionId;
        this.upDownFrom = upDownFrom;
        this.upDownTo = upDownTo;
        this.addDateFrom = addDateFrom;
        this.addDateTo = addDateTo;
    }

    public OpinionVoteFilter(int id, Integer opinionId, Integer upDownFrom, Integer upDownTo, Date addDateFrom,
            Date addDateTo) {
        super(id);
        this.opinionId = opinionId;
        this.upDownFrom = upDownFrom;
        this.upDownTo = upDownTo;
        this.addDateFrom = addDateFrom;
        this.addDateTo = addDateTo;
    }

    public OpinionVoteFilter() {

    }

    public Integer getOpinionId() {
        return opinionId;
    }

    public void setOpinionId(Integer opinionId) {
        this.opinionId = opinionId;
    }

    public Integer getUpDownFrom() {
        return upDownFrom;
    }

    public void setUpDownFrom(Integer upDownFrom) {
        this.upDownFrom = upDownFrom;
    }

    public Integer getUpDownTo() {
        return upDownTo;
    }

    public void setUpDownTo(Integer upDownTo) {
        this.upDownTo = upDownTo;
    }
}
