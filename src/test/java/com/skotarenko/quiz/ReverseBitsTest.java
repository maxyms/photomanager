package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class ReverseBitsTest {
    @Test
    public void testNumberOfBits() {
        Assert.assertEquals(0, new ReverseBits().reverseBits(0));
        Assert.assertEquals(2, new ReverseBits().reverseBits(1));
        Assert.assertEquals(1, new ReverseBits().reverseBits(2));
    }

    @Ignore
    @Test
    public void test1() {
        System.out.println(new ReverseBits().reverseBits(1));
        //        System.out.println(new ReverseBits().reverseBits(2));
    }
}
