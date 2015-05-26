package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class RotateArrayTest {
    @Ignore
    @Test
    public void testRotateStringWords() {
        String sentense = "Rotate a string of simple English words by some step shift";
        String[] words = sentense.split(" ");
        new RotateArray().rotate(words, 3);
    }

    @Ignore
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

    @Ignore
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

    @Ignore
    @Test
    public void testRotateArray3() {
        int[] arr = new int[] {};
        //        new RotateArray().rotate3(arr, 3);
        //        Assert.assertArrayEquals(new int[] {}, arr);
        //        arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        //        new RotateArray().rotate3(arr, 0);
        //        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7 }, arr);
        //        arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        //        new RotateArray().rotate3(arr, 3);
        //        Assert.assertArrayEquals(new int[] { 5, 6, 7, 1, 2, 3, 4 }, arr);
        //        arr = new int[] { -1 };
        //        new RotateArray().rotate3(arr, 2);
        //        Assert.assertArrayEquals(new int[] { -1 }, arr);
        //        arr = new int[] { 1, 2 };
        //        new RotateArray().rotate3(arr, 3);
        //        Assert.assertArrayEquals(new int[] { 2, 1 }, arr);
        //        arr = new int[] { 1, 2, 3, 4, 5, 6 };
        //        new RotateArray().rotate3(arr, 2);
        //        Assert.assertArrayEquals(new int[] { 5, 6, 1, 2, 3, 4 }, arr);
        arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };
        new RotateArray().rotate3(arr, 10);
        Assert.assertArrayEquals(new int[] { 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 1, 2, 3, 4, 5, 6, 7 }, arr);
        /**/
        //        arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27 };
        //        new RotateArray().rotate3(arr, 38);
        //        Assert.assertArrayEquals(new int[] { 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 }, arr);
    }

    @Test
    public void testRotateArray4() {
        int[] arr = new int[] {};
        //        new RotateArray().rotate4(arr, 3);
        //        Assert.assertArrayEquals(new int[] {}, arr);
        //        arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        //        new RotateArray().rotate4(arr, 0);
        //        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7 }, arr);
        //        arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        //        new RotateArray().rotate4(arr, 3);
        //        Assert.assertArrayEquals(new int[] { 5, 6, 7, 1, 2, 3, 4 }, arr);
        //        arr = new int[] { -1 };
        //        new RotateArray().rotate4(arr, 2);
        //        Assert.assertArrayEquals(new int[] { -1 }, arr);
        //        arr = new int[] { 1, 2 };
        //        new RotateArray().rotate4(arr, 3);
        //        Assert.assertArrayEquals(new int[] { 2, 1 }, arr);
        arr = new int[] { 1, 2, 3, 4, 5, 6 };
        new RotateArray().rotate4(arr, 2);
        Assert.assertArrayEquals(new int[] { 5, 6, 1, 2, 3, 4 }, arr);
        //        arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };
        //        new RotateArray().rotate4(arr, 10);
        //        Assert.assertArrayEquals(new int[] { 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 1, 2, 3, 4, 5, 6, 7 }, arr);
        /**/
        //        arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27 };
        //        new RotateArray().rotate4(arr, 38);
        //        Assert.assertArrayEquals(new int[] { 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 }, arr);
    }
}
