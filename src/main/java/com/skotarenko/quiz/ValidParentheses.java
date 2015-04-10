package com.skotarenko.quiz;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 * @author maxyms
 *
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        char[] st = new char[s.length()];
        int p = 0;
        char c = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (p == 0) {
                st[p] = c;
                p++;
            } else {
                if ((st[p - 1] == '(' && c == ')') || (st[p - 1] == '[' && c == ']') || (st[p - 1] == '{' && c == '}')) {
                    st[p - 1] = 0;
                    p--;
                } else if (c == '(' || c == '[' || c == '{') {
                    st[p] = c;
                    p++;
                } else {
                    return false;
                }
            }
        }
        return p == 0;
    }
}
