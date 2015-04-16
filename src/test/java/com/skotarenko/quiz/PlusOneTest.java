package com.skotarenko.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PlusOneTest {
    @Test
    public void plusOneEmptyTest() {
        validate(Arrays.asList(new Integer[] {}), new PlusOne().plusOne(Arrays.asList(new Integer[] {})));
    }

    @Test
    public void plusOneTest() {
        validate(Arrays.asList(new Integer[] { 2, 3, 5 }), new PlusOne().plusOne(Arrays.asList(new Integer[] { 2, 3, 4 })));
    }

    @Test
    public void plusOneTest2() {
        validate(Arrays.asList(new Integer[] { 1, 4, 0 }), new PlusOne().plusOne(Arrays.asList(new Integer[] { 1, 3, 9 })));
    }

    @Test
    public void plusOneTest3() {
        validate(Arrays.asList(new Integer[] { 1, 0, 0, 0 }), new PlusOne().plusOne(Arrays.asList(new Integer[] { 9, 9, 9 })));
    }

    @Test
    public void plusOneTest4() {
        validate(Arrays.asList(new Integer[] { 9, 3, 0 }), new PlusOne().plusOne(Arrays.asList(new Integer[] { 9, 2, 9 })));
    }

    @Test
    public void plusOneTest5() {
        List<Integer> exp = new ArrayList<Integer>();
        exp.add(1);
        List<Integer> digits = new ArrayList<Integer>();
        for (int i = 0; i < 10000000; i++) {
            exp.add(0);
            digits.add(9);
        }
        validate(exp, new PlusOne().plusOne(digits));
    }

    private void validate(List<Integer> exp, List<Integer> arr) {
        Assert.assertEquals(exp.size(), arr.size());
        for (int i = 0; i < exp.size(); i++) {
            Assert.assertEquals("At position {" + i + "}", exp.get(i), arr.get(i));
        }
    }
}
