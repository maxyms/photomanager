package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class LongestValidParenthesesTest {
    @Test
    public void testLongestValidParentheses() {
        Assert.assertEquals(0, new LongestValidParentheses().longestValidParentheses(""));
        Assert.assertEquals(0, new LongestValidParentheses().longestValidParentheses(")("));
        Assert.assertEquals(0, new LongestValidParentheses().longestValidParentheses(")(("));
        Assert.assertEquals(0, new LongestValidParentheses().longestValidParentheses("(((((((("));
        Assert.assertEquals(2, new LongestValidParentheses().longestValidParentheses("(()"));
        Assert.assertEquals(4, new LongestValidParentheses().longestValidParentheses(")()())"));
        Assert.assertEquals(2, new LongestValidParentheses().longestValidParentheses("()(()"));
    }
}
