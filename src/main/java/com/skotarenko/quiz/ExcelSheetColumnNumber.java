package com.skotarenko.quiz;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

    For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    
 * @author maxyms
 *
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        char base = 'A' - 1;
        int n = 0;
        int pow = 1;
        char[] chars = s.toCharArray();
        int l = chars.length;
        for (int i = l - 1; i >= 0; i--) {
            n += (chars[i] - base) * pow;
            pow = 26 * pow;
        }
        return n;
    }
}
