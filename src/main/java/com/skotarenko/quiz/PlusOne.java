package com.skotarenko.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

    The digits are stored such that the most significant digit is at the head of the list.

 * @author maxyms
 *
 */
public class PlusOne {
    public List<Integer> plusOne(List<Integer> digits) {
        int i = digits.size();
        int memory = i > 0 ? 1 : 0;
        int val = 0;
        while (memory > 0 && --i >= 0) {
            val = digits.get(i) + memory;
            if (val > 9) {
                memory = 1;
                digits.set(i, 0);
            } else {
                memory = 0;
                digits.set(i, val);
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        if (memory > 0) {
            res.add(1);
        }
        res.addAll(digits);
        return res;
    }
}
