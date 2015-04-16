package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class ReverseBitsTest {
    @Test
    public void testReverseBits() {
        Assert.assertEquals(0, new ReverseBits().reverseBits(0));
        Assert.assertEquals(964176192, new ReverseBits().reverseBits(43261596));
        Assert.assertEquals(1, new ReverseBits().reverseBits(Integer.MAX_VALUE + 1));
    }
}
