package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class RotateArrayTest {
    @Test
    public void testRotateStringWords() {
        String sentense = "Rotate a string of simple English words by some step shift";
        String[] words = sentense.split(" ");
        new RotateArray().rotate(words, 3);
    }

    @Test
    public void testRotateArray1() {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        new RotateArray().rotate1(arr, 3);
        Assert.assertArrayEquals(new int[] { 5, 6, 7, 1, 2, 3, 4 }, arr);
        arr = new int[] { -1 };
        new RotateArray().rotate1(arr, 2);
        Assert.assertArrayEquals(new int[] { -1 }, arr);
        arr = new int[] { 1, 2 };
        new RotateArray().rotate1(arr, 3);
        Assert.assertArrayEquals(new int[] { 2, 1 }, arr);
        arr = new int[] { 1, 2, 3, 4, 5, 6 };
        new RotateArray().rotate1(arr, 2);
        Assert.assertArrayEquals(new int[] { 5, 6, 1, 2, 3, 4 }, arr);
    }

    @Test
    public void testRotateArray2() {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        new RotateArray().rotate2(arr, 3);
        Assert.assertArrayEquals(new int[] { 5, 6, 7, 1, 2, 3, 4 }, arr);
        arr = new int[] { -1 };
        new RotateArray().rotate2(arr, 2);
        Assert.assertArrayEquals(new int[] { -1 }, arr);
        arr = new int[] { 1, 2 };
        new RotateArray().rotate2(arr, 3);
        Assert.assertArrayEquals(new int[] { 2, 1 }, arr);
        arr = new int[] { 1, 2, 3, 4, 5, 6 };
        new RotateArray().rotate2(arr, 2);
        Assert.assertArrayEquals(new int[] { 5, 6, 1, 2, 3, 4 }, arr);
    }

    @Test
    public void testRotateArray3() {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        //        new RotateArray().rotate3(arr, 3);
        //        Assert.assertArrayEquals(new int[] { 5, 6, 7, 1, 2, 3, 4 }, arr);
        //        arr = new int[] { -1 };
        //        new RotateArray().rotate3(arr, 2);
        //        Assert.assertArrayEquals(new int[] { -1 }, arr);
        //        arr = new int[] { 1, 2 };
        //        new RotateArray().rotate3(arr, 3);
        //        Assert.assertArrayEquals(new int[] { 2, 1 }, arr);
        arr = new int[] { 1, 2, 3, 4, 5, 6 };
        new RotateArray().rotate3(arr, 2);
        Assert.assertArrayEquals(new int[] { 5, 6, 1, 2, 3, 4 }, arr);
    }
}
