package org.tornado.test;

import org.junit.Assert;
import org.junit.Test;


public class FormatTest {

    public static final String COMMA = ",";
    public static final String PERIOD = ".";

    private String formatPrice(String p) {
        return p.substring(2, p.length() - 1).replace(COMMA, PERIOD);
    }

    /**
     * Test ofdat de verwachte vervanging plaats vindt.
     **/

    @Test
    public void testOne() {

        Assert.assertEquals(formatPrice("€ 99.99*"), "99.99");

    }

    /**
     * Test ofdat dit een foute uitkomst geeft.
     **/

    @Test
    public void testTwo() {

        Assert.assertNotEquals(formatPrice("99.99"), "99.99");

    }

}
