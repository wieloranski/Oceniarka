package oceniarka.management;

import oceniarka.Domain.OpinionVote;
import oceniarka.Filters.OpinionVoteFilter;
import oceniarka.framework.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by eryk on 07.12.15.
 */
public class OpinionVoteMapperTest extends AbstarctMapperTest<OpinionVote, OpinionVoteFilter> {

    @Autowired
    OpinionVotesMgmt opinionVotesMgmt;

    @PostConstruct
    @Override
    public void setManager() {
        manager = opinionVotesMgmt;
    }

    @Override
    public void beforeInsert() {

        defaultObject = new OpinionVote(1, 1, new Date());
        anotherDefaultObject = new OpinionVote(1, 2, new Date());
        domainName = "OpinionVote";

        insertedList = new ArrayList<>();
        insertedList.add(new OpinionVote(1, 1, new Date()));
        insertedList.add(new OpinionVote(1, 2, new Date()));
        insertedList.add(new OpinionVote(1, 3, new Date()));
        insertedList.add(new OpinionVote(1, 7, new Date()));

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, -1);
        Date fromDate = calendar.getTime();

        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, 1);
        Date toDate = calendar.getTime();


        filterExpectedSizeMap = new ArrayList<>();
        filterExpectedSizeMap.add(new Pair<>(new OpinionVoteFilter(1, 1, 3, fromDate, toDate), 3));
    }

    @Override
    public void getAll() {

    }

}
