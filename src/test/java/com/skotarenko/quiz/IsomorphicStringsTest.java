package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class IsomorphicStringsTest {
    @Test
    public void test() {
        Assert.assertTrue("'egg' == 'add'", new IsomorphicStrings().isIsomorphic("egg", "add"));
        Assert.assertFalse("'foo' == 'bar'", new IsomorphicStrings().isIsomorphic("foo", "bar"));
        Assert.assertTrue("'paper' == 'title'", new IsomorphicStrings().isIsomorphic("paper", "title"));
        Assert.assertFalse("'ab' == 'aa'", new IsomorphicStrings().isIsomorphic("ab", "aa"));
    }
}
