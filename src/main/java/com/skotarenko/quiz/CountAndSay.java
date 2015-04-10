package com.skotarenko.quiz;

public class CountAndSay {
    public String countAndSay(int n) {
        String res = "";
        if (n == 0) {
            return res;
        }
        res = "1";
        StringBuilder sb = null;
        for (int i = 1; i < n; i++) {
            char toSay = res.charAt(0);
            int count = 1;
            sb = new StringBuilder();
            for (int j = 1; j < res.length(); j++) {
                char cc = res.charAt(j);
                if (toSay != cc) {
                    sb.append(count).append(toSay);
                    toSay = cc;
                    count = 1;
                } else {
                    count++;
                }
            }
            sb.append(count).append(toSay);
            res = sb.toString();
        }
        return res;
    }
}
