package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class MajorityElementTest {
    @Test
    public void testReverseBits() {
        Assert.assertEquals(5, new MajorityElement().majorityElement(new int[] { 2, 5, 5, 2, 5 }));
        Assert.assertEquals(4, new MajorityElement().majorityElement(new int[] { 2, 5, 4, 6, 4, 1, 4, 3, 4, 4, 4, 6, 4, 6, 4, 4, 8, 4 }));
        Assert.assertEquals(0, new MajorityElement().majorityElement(new int[] { -2147483648, 0, 0 }));
        Assert.assertEquals(1, new MajorityElement().majorityElement(new int[] { 1 }));
    }

    @Test
    public void testLongArray() {
        final int N = 10000000;
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = 1;
        }
        Assert.assertEquals(1, new MajorityElement().majorityElement(num));
    }
}
