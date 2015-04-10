package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class ValidParenthesesTest {
    @Test
    public void testValidParentheses() {
        Assert.assertTrue("Check '()'", new ValidParentheses().isValid("()"));
        Assert.assertTrue("Check '()[]{}'", new ValidParentheses().isValid("()[]{}"));
        Assert.assertTrue("Check '()[](){}(){}[]'", new ValidParentheses().isValid("()[](){}(){}[]"));
        Assert.assertTrue("Check '([])'", new ValidParentheses().isValid("([])"));
        Assert.assertTrue("Check '([{[(())[]]}])'", new ValidParentheses().isValid("([{[(())[]]}])"));
    }

    @Test
    public void testInvalidParentheses() {
        Assert.assertFalse("Check '(]'", new ValidParentheses().isValid("(]"));
        Assert.assertFalse("Check '([)]'", new ValidParentheses().isValid("([)]"));
        Assert.assertFalse("Check '()]'", new ValidParentheses().isValid("()]"));
        Assert.assertFalse("Check '()['", new ValidParentheses().isValid("()["));
        Assert.assertFalse("Check '())'", new ValidParentheses().isValid("())"));
        Assert.assertFalse("Check '([}{])'", new ValidParentheses().isValid("([}{])"));
    }
}
