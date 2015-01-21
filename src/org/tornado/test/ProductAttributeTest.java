package org.tornado.test;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ProductAttributeTest {

    public static final String COLUMN_ONE = "techDataCol1";
    public static final String TCOL_ONE = "c1";
    public static final String MOTHERBOARD_TABLE_NAME = "techData";
    public static final String TD = "td";
    public static final String EMPTY = "";

    public static final String[] EXPECTED = {"Modelnaam", "Serie", "Bouwvorm", "Capaciteit", "Interface", "Data-transferrate", "Toerental", "Cache", "Geluidsproductie", "Stroomvebruik", "Features", "Schokbestendig", "Info", "Afmetingen (BxHxD)", "Gewicht", "Overige informatie", "Garantie"};

    public List<String> getProductAttributes(Document doc) {
        Elements firstRow = doc.getElementsByClass(COLUMN_ONE);
        List<String> productAttributes = new ArrayList<>();
        if (!firstRow.isEmpty()) {
            for (Element element : firstRow) {
                productAttributes.add(element.text());
            }
        } else {
            Elements rows = doc.getElementsByClass(MOTHERBOARD_TABLE_NAME);
            for (Element row : rows.select(TD)) {
                Elements col = row.getElementsByClass(TCOL_ONE);

                if (!col.text().equals(EMPTY)) {
                    productAttributes.add(col.text());
                }
            }
        }
        return productAttributes;
    }

    /**
     * Test ofdat de opgehaalde data van de website gelijk is aan het verwachte resultaat.
     **/

    @Test
    public void testOne() {

        try {
            Document doc = Jsoup.connect("https://www.alternate.nl/html/product/1083069").get();
            Assert.assertEquals(getProductAttributes(doc), Arrays.asList(EXPECTED));
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Test ofdat de opgehaalde data van verschillende producten verschilt op inhoud en lengte
     **/

    @Test
    public void testTwo() {

        try {
            Document doc = Jsoup.connect("https://www.alternate.nl/html/product/1006160").get();
            List<String> different = getProductAttributes(doc);
            doc = Jsoup.connect("https://www.alternate.nl/html/product/1018540").get();
            List<String> list = getProductAttributes(doc);
            Assert.assertNotEquals(list, different);
            Assert.assertNotEquals(list.size(), different);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Test ofdat de functie ook bij moederborden werkt
     **/

    @Test
    public void testThree() {
        try {
            Document doc = Jsoup.connect("https://www.alternate.nl/html/product/1125042").get();
            Assert.assertTrue(getProductAttributes(doc).size() > 0);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}