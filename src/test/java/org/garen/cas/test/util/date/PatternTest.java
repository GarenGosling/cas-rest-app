package org.garen.cas.test.util.date;

import org.garen.cas.util.date.Pattern;
import org.junit.Test;

/**
 * Test Pattern
 *
 * @author Garen Gosling
 * @create 2017-09-07 00:05
 * @since v1.0
 */
public class PatternTest {

    @Test
    public void testPattern(){
        System.out.println(Pattern.DATE.value());
        System.out.println(Pattern.TIME.value());
    }
}
