package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class CountAndSayTest {
    @Test
    public void testValidParentheses() {
        Assert.assertEquals("", new CountAndSay().countAndSay(0));
        Assert.assertEquals("1", new CountAndSay().countAndSay(1));
        Assert.assertEquals("11", new CountAndSay().countAndSay(2));
        Assert.assertEquals("21", new CountAndSay().countAndSay(3));
        Assert.assertEquals("1211", new CountAndSay().countAndSay(4));
        Assert.assertEquals("111221", new CountAndSay().countAndSay(5));
        Assert.assertEquals("312211", new CountAndSay().countAndSay(6));
        Assert.assertEquals("13112221", new CountAndSay().countAndSay(7));
        Assert.assertEquals("1113213211", new CountAndSay().countAndSay(8));
    }
}
