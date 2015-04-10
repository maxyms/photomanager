package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfBitsTest {
    @Test
    public void testNumberOfBits() {
        Assert.assertEquals(0, new NumberOfBits().hammingWeight(0));
        Assert.assertEquals(1, new NumberOfBits().hammingWeight(1));
        Assert.assertEquals(1, new NumberOfBits().hammingWeight(2));
        Assert.assertEquals(2, new NumberOfBits().hammingWeight(3));
        Assert.assertEquals(1, new NumberOfBits().hammingWeight(4));
        Assert.assertEquals(3, new NumberOfBits().hammingWeight(11));
        Assert.assertEquals(5, new NumberOfBits().hammingWeight(121));
    }

    @Test
    public void testNumberOfBitsShift() {
        Assert.assertEquals(0, new NumberOfBits().hammingWeightShift(0));
        Assert.assertEquals(1, new NumberOfBits().hammingWeightShift(1));
        Assert.assertEquals(1, new NumberOfBits().hammingWeightShift(2));
        Assert.assertEquals(2, new NumberOfBits().hammingWeightShift(3));
        Assert.assertEquals(1, new NumberOfBits().hammingWeightShift(4));
        Assert.assertEquals(3, new NumberOfBits().hammingWeightShift(11));
        Assert.assertEquals(5, new NumberOfBits().hammingWeightShift(121));
        Assert.assertEquals(1, new NumberOfBits().hammingWeightShift(Integer.parseUnsignedInt("2147483648")));
    }
}
