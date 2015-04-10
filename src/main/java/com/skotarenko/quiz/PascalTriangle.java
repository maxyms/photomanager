package com.skotarenko.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

 * @author maxyms
 *
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cRow = new ArrayList<>();
        List<Integer> pRow = new ArrayList<>();
        if (numRows > 0) {
            cRow.add(1);
            res.add(cRow);
            pRow = cRow;
        }
        for (int k = 1; k < numRows; k++) {
            cRow = new ArrayList<>();
            cRow.add(1);
            for (int i = 1; i < k; i++) {
                cRow.add(pRow.get(i) + pRow.get(i - 1));
            }
            cRow.add(k, 1);
            res.add(cRow);
            pRow = cRow;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle().generate(5));
    }
}
