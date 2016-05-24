package oceniarka.management;

import oceniarka.Domain.Opinion;
import oceniarka.Filters.OpinionFilter;
import oceniarka.framework.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by eryk on 06.12.15.
 */
public class OpinionMapperTest extends AbstarctMapperTest<Opinion, OpinionFilter> {

    @Autowired
    OpinionMgmt opinionMgmt;

    @PostConstruct
    @Override
    public void setManager() {
        manager = opinionMgmt;
    }

    @Override
    public void beforeInsert() {
        Date currentTime = new Date();
        defaultObject = new Opinion(null, 1, 1, 8, 9, 10, currentTime, null);
        anotherDefaultObject = new Opinion(null, 1, 1, 6, 7, 5, currentTime, "something");
        domainName = "Opinion";

        insertedList = new ArrayList<>();
        insertedList.add(new Opinion(null, 1, 1, 8, 9, 10, currentTime, null));
        insertedList.add(new Opinion(null, 1, 1, 6, 7, 5, currentTime, null));
        insertedList.add(new Opinion(null, 1, 1, 2, 3, 4, currentTime, null));
        insertedList.add(new Opinion(null, 1, 1, 4, 5, 6, currentTime, null));

        prepareFilters();
    }

    private void prepareFilters() {
        Date fromDate = new Date();
        Date toDate = new Date();

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(fromDate);
        calendar.add(Calendar.MINUTE, -1);
        Date from = new Date(calendar.getTime().getTime());

        calendar.setTime(toDate);
        calendar.add(Calendar.MINUTE, 1);
        Date to = new Date(calendar.getTime().getTime());
        filterExpectedSizeMap = new ArrayList<>();

        filterExpectedSizeMap.add(new Pair<>(new OpinionFilter(null, null, 5, 10, 5, 10, 5, 10, from, to), 2));
        filterExpectedSizeMap.add(new Pair<>(new OpinionFilter(1, null, null, null, null, null, null, null, from, to), 4));
        filterExpectedSizeMap.add(
                new Pair<>(new OpinionFilter(null, 1, null, null, null, null, null, null, from, to), 4));
    }

}
