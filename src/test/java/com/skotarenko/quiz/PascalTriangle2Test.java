package com.skotarenko.quiz;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PascalTriangle2Test {
    @Test
    public void testGetRow() {
        int[] expected = new int[] { 1, 5, 10, 10, 5, 1 };
        List<Integer> actual = new PascalTriangle2().getRow(5);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertEquals("Index " + i + " : ", expected[i], actual.get(i).intValue());
        }
    }
}
