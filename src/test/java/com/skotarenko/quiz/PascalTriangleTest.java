package com.skotarenko.quiz;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PascalTriangleTest {
    @Test
    public void testGenerate() {
        int[][] expected = new int[][] { new int[] { 1 }, new int[] { 1, 1 }, new int[] { 1, 2, 1 }, new int[] { 1, 3, 3, 1 }, new int[] { 1, 4, 6, 4, 1 } };
        List<List<Integer>> actual = new PascalTriangle().generate(5);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                Assert.assertEquals("Index " + i + "," + j + " : ", expected[i][j], actual.get(i).get(j).intValue());
            }
        }
    }
}
