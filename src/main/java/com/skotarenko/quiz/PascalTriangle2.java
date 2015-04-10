package com.skotarenko.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.

    For example, given k = 3,
    Return [1,3,3,1].

    Note:
    Could you optimize your algorithm to use only O(k) extra space?

 * @author maxyms
 *
 */
public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int k = 0; k <= rowIndex; k++) {
            int mem = 1;
            for (int i = 1; i < k; i++) {
                int tmp = res.get(i);
                int c = mem + tmp;
                mem = tmp;
                res.set(i, c);
            }
            res.add(k, 1);
        }
        return res;
    }
}
