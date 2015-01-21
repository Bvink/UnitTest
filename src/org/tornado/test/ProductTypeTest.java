package org.tornado.test;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import org.junit.Assert;
import org.junit.Test;



public class ProductTypeTest {

    public static final String PRODUCT_TYPE_SELECTOR_ALTERNATE = ".breadCrumbs > span:nth-child(2) > a:nth-child(1) > span:nth-child(1)";
    public static final String PRODUCT_TYPE_SELECTOR_PARADIGIT = "div.breadcrumbcontainer:nth-child(3) > a:nth-child(1)";

    public String getProductTypeAlternate(Document doc) {
        String selector = PRODUCT_TYPE_SELECTOR_ALTERNATE;
        Elements elements = doc.select( selector );
        return elements.get(0).text();
    }

    public String getProductTypeParadigit(Document doc) {
        String selector = PRODUCT_TYPE_SELECTOR_PARADIGIT;
        Elements elements = doc.select( selector );
        return elements.get(0).text();
    }

    /**
     * Test ofdat de opgehaalde data van de website gelijk is aan het verwachte resultaat.
     **/

    @Test
    public void testOne() {

        try {
            Document doc = Jsoup.connect("https://www.alternate.nl/html/product/1083069").get();
            Assert.assertEquals(getProductTypeAlternate(doc), "Harde schijven intern");
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Test ofdat de opgehaalde data van de website gelijk is aan het verwachte resultaat.
     **/

    @Test
    public void testTwo() {

        try {
            Document doc = Jsoup.connect("http://www.paradigit.nl/kingston-1gb-pc3-10600-sodimm/80001370/details.aspx").get();
            Assert.assertEquals(getProductTypeParadigit(doc), "Geheugen intern");
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}