package oceniarka.framework;

import java.util.Date;

/**
 * Created by eryk on 09.12.15.
 */
public class DateTruncator {

    public static Date trancuateMilliseconds(Date date) {
        long time = date.getTime();
        date.setTime((time / 1000) * 1000);
        return date;
    }

}
