package org.tornado.test;

import org.junit.Assert;
import org.junit.Test;

public class UrlCreatorTest {

    public static final String ALTERNATE_URL = "https://www.alternate.nl";
    public static final String ALTERNATE_PRODUCT_LOCATION = "/html/product/";

    public String createUrl(String productNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(ALTERNATE_URL)
                .append(ALTERNATE_PRODUCT_LOCATION)
                .append(productNumber);
        return sb.toString();
    }

    /**
     * Test ofdat een url goed geformatteerd wordt.
     **/

    @Test
    public void testTen() {

        int i = 10;
        Assert.assertTrue(createUrl(Integer.toString(i)).equals("https://www.alternate.nl/html/product/" + i));

    }
}
