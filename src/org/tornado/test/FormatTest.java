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
     * Test ofdat de prijzen van Alternate correct geformatteerd worden voor de database.
     **/

    @Test
    public void testThree() {

        Assert.assertEquals(formatPrice("€ 99.99*"), "99.99");

    }

    /**
     * Test ofdat deze methode bij andere websites incorrect is.
     **/

    @Test
    public void testFour() {

        Assert.assertNotEquals(formatPrice("99.99"), "99.99");

    }

}
