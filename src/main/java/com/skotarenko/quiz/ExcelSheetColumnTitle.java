package com.skotarenko.quiz;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

    For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    
 * @author maxyms
 *
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        char[] chars = new char[32];
        int base = 'A';
        int i = 0;
        while (n > 26) {
            chars[31 - i] = (char) (base + (n - 1) % 26);
            n = (n - 1) / 26;
            i++;
        }
        chars[31 - i] = (char) (base + (n - 1));
        return new String(chars, 31 - i, i + 1);
    }
}
