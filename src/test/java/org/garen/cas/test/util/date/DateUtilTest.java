package org.garen.cas.test.util.date;

import org.garen.cas.util.date.DateUtil;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

/**
 * Test DateUtil
 *
 * @author Garen Gosling
 * @create 2017-09-07 00:24
 * @since v1.0
 */
public class DateUtilTest {

    @Test
    public void parseDate() throws ParseException {
        System.out.println(DateUtil.parseDate("2017-12-15"));
        System.out.println(DateUtil.parseDate("2017-12-15 12:12:12"));
    }

    @Test
    public void parseTime() throws ParseException {
        System.out.println(DateUtil.parseTime("2017-12-15"));
        System.out.println(DateUtil.parseTime("2017-12-15 12:12:12"));
    }

    @Test
    public void parseDateString() throws ParseException {
        System.out.println(DateUtil.parseDateString(new Date()));
    }

    @Test
    public void parseTimeString() throws ParseException {
        System.out.println(DateUtil.parseTimeString(new Date()));
    }

    @Test
    public void parseDateString2() throws ParseException {
        System.out.println(DateUtil.parseDateString("2017-09-07"));
        System.out.println(DateUtil.parseDateString("2017-09-07 00:44:30"));
    }

    @Test
    public void parseTimeString2() throws ParseException {
        System.out.println(DateUtil.parseTimeString("2017-09-07"));
        System.out.println(DateUtil.parseTimeString("2017-09-07 00:44:30"));
    }

    @Test
    public void getTime() throws ParseException {
        Long l = DateUtil.getTime("2017-09-07 12:10:27");
        System.out.println(l);
    }

    @Test
    public void parseDate2() throws ParseException {
        Date date = null;
        Long l = DateUtil.getTime("2017-09-07 12:10:27");
        System.out.println(l);
        if(l != null){
            date = DateUtil.parseTime(l);
        }
        System.out.println(date);
    }

    @Test
    public void minusTime() throws ParseException {
        Date time = DateUtil.parseTime("2017-09-07 12:00:00");
        Date subtractedTime = DateUtil.parseTime("2017-09-05 10:00:00");
        Long days = DateUtil.minusTime(time, subtractedTime);
        System.out.println(days);
    }

    @Test
    public void minusDate() throws ParseException {
        Date date = DateUtil.parseDate("2017-09-07 12:00:00");
        Date subtractedDate = DateUtil.parseDate("2017-09-05 10:00:00");
        Long days = DateUtil.minusDate(date, subtractedDate);
        System.out.println(days);
    }

    @Test
    public void addDate() throws ParseException {
        Date date = DateUtil.addDays(new Date(), 2);
        System.out.println(date);
    }

    @Test
    public void minusDays() throws ParseException {
        Date date = DateUtil.minusDays(new Date(), 2);
        System.out.println(date);
    }
}
