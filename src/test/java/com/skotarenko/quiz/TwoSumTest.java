package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {
    @Test
    public void twoSumSorted() {
        Assert.assertArrayEquals(new int[] { 1, 2 }, new TwoSum().twoSum(new int[] { 2, 7, 11, 15 }, 9));
    }

    @Test
    public void twoSum() {
        Assert.assertArrayEquals(new int[] { 3, 7 }, new TwoSum().twoSum(new int[] { 3, 58, 20, 4, 99, 2, 7, 11, 15 }, 27));
        Assert.assertArrayEquals(new int[] { 4, 8 }, new TwoSum().twoSum(new int[] { 3, 58, -5, 20, 4, 99, 2, 7, 11, 15 }, 27));
    }

    @Test
    public void twoSumLongArray() {
        int N = 200000;
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = i * 2;
        }
        Assert.assertArrayEquals(new int[] { N - 1, N }, new TwoSum().twoSum(numbers, numbers[N - 2] + numbers[N - 1]));
    }
}
