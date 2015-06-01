package com.skotarenko.quiz;

/**
 * Given two strings s and t, determine if they are isomorphic.

    Two strings are isomorphic if the characters in s can be replaced to get t.
    
    All occurrences of a character must be replaced with another character while preserving the order of characters. 
    No two characters may map to the same character but a character may map to itself.
    
    For example,
    Given "egg", "add", return true.
    
    Given "foo", "bar", return false.
    
    Given "paper", "title", return true.
    
    Note:
    You may assume both s and t have the same length.

 * @author maxyms
 *
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        char[] map = new char[256], res = new char[s.length()];
        char sc = 0, c = 0;
        int l = s.length();
        for (int i = 0; i < l; i++) {
            sc = s.charAt(i);
            c = map[sc];
            if (c == 0) {
                c = t.charAt(i);
                for (int j = 0; j < 256; j++) {
                    if (map[j] == c) {
                        return false;
                    }
                }
                map[sc] = c;
            }
            res[i] = c;
        }
        return new String(res).equals(t);
    }
}
