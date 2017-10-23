package org.garen.cas.test.util.esapi;

import org.garen.cas.util.EsapiUtil;
import org.junit.Test;

/**
 * Test EsapiUtilTest
 *
 * @author Garen Gosling
 * @create 2017-09-08 18:01
 * @since v1.0
 */
public class EsapiUtilTest {

    @Test
    public void sqlTest(){
        String name = "hello";
        String sql = "select * from test where name = '"+name+"'";
        String sql2 = "select * from test where name = '"+ EsapiUtil.sql(name)+"'";
        System.out.println(sql);
        System.out.println(sql2);

        /*----------------这个不是很合理，但是是这个意思--------------*/

        String name2 = "(select name from test where name like '%g%')";
        String sql3 = "select * from test where name = "+name2;
        String sql4 = "select * from test where name = "+ EsapiUtil.sql(name2);
        System.out.println(sql3);
        System.out.println(sql4);




    }
}
