package com.skotarenko.quiz;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int res = 0;
        int currentSeq = 0;
        int sum = 0;
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(') {
                sum++;
            } else if (c == ')') {
                sum--;
            }
            if (sum >= 0) {
                currentSeq++;
            } else {
                res = res > currentSeq ? res : currentSeq;
                currentSeq = 0;
                sum = 0;
            }
        }
        if (currentSeq > 0) {
            res = res > currentSeq - sum ? res : currentSeq - sum;
        }
        return res;
    }
}
