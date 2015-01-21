package org.tornado.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CombineTest {

    public static final String SPACE = " ";
    public static final String LINE_SEPERATOR = System.getProperty("line.separator");

    private StringBuilder combineValues(List<String> productAttributes, List<String> productValues) {
        List<String> combined = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (productAttributes.size() == productValues.size()) {
            for (int i = 0; i < productAttributes.size() && i < productValues.size(); i++) {
                combined.add(productAttributes.get(i) + SPACE + productValues.get(i));
            }
        }
        for (String s : combined) {
            sb.append(s);
            sb.append(LINE_SEPERATOR);
        }
        return sb;
    }

    /**
     * Test ofdat het combineren van attributen en waarden succesvol gebeurt.
     **/

    @Test
    public void testOne() {
        List<String> listOne = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();
        listOne.add("one");
        listOne.add("three");
        listTwo.add("two");
        listTwo.add("four");

        String expected = "one" + SPACE + "two" + LINE_SEPERATOR + "three" + SPACE + "four" + LINE_SEPERATOR;

        Assert.assertEquals(combineValues(listOne, listTwo).toString(), expected);

    }

    /**
     * Test ofdat het combineren van attributen en waarden van een product stopt als er meer of miner attributen dan waarden zijn.
     **/

    @Test
    public void testTwo() {
        List<String> listOne = new ArrayList<>();
        List<String> listTwo = new ArrayList<>();
        listOne.add("one");
        listOne.add("three");
        listOne.add("five");
        listTwo.add("two");
        listTwo.add("four");

        Assert.assertEquals(combineValues(listOne, listTwo).length(), 0);

    }
}
