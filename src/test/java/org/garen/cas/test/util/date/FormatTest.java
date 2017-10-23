package org.garen.cas.test.util.date;

import org.junit.Test;

import java.text.ParseException;

import static org.garen.cas.util.date.Format.formatDate;
import static org.garen.cas.util.date.Format.formatTime;

/**
 * Test Format
 *
 * @author Garen Gosling
 * @create 2017-09-07 00:05
 * @since v1.0
 */
public class FormatTest {

    @Test
    public void formatDateTimeTest() throws ParseException {
        String[] dateStrArray=new String[]{
                "2014-03-12 12:05:34",
                "2014-03-12 12:05",
                "2014-03-12 12",
                "2014-03-12",
                "2014-03",
                "2014",
                "20140312120534",
                "2014/03/12 12:05:34",
                "2014/3/12 12:5:34",
                "2014年3月12日 13时5分34秒",
                "201403121205",
                "1234567890",
                "20140312",
                "201403",
                "2000 13 33",
                "30.12.2013",
                "12.21.2013",
                "21.1",
                "13:05:34",
                "12:05",
                "14.1.8",
                "14.10.18",
                "13552979387"
        };
        for(int i=0;i<dateStrArray.length;i++){
            System.out.println(dateStrArray[i] +"------------------------------".substring(1,30-dateStrArray[i].length())+ formatTime(dateStrArray[i]));
        }
    }

    @Test
    public void formatDateTest() throws ParseException {
        String[] dateStrArray=new String[]{
                "2014-03-12 12:05:34",
                "2014-03-12 12:05",
                "2014-03-12 12",
                "2014-03-12",
                "2014-03",
                "2014",
                "20140312120534",
                "2014/03/12 12:05:34",
                "2014/3/12 12:5:34",
                "2014年3月12日 13时5分34秒",
                "201403121205",
                "1234567890",
                "20140312",
                "201403",
                "2000 13 33",
                "30.12.2013",
                "12.21.2013",
                "21.1",
                "13:05:34",
                "12:05",
                "14.1.8",
                "14.10.18",
                "13552979387"
        };
        for(int i=0;i<dateStrArray.length;i++){
            System.out.println(dateStrArray[i] +"------------------------------".substring(1,30-dateStrArray[i].length())+ formatDate(dateStrArray[i]));
        }
    }
}
