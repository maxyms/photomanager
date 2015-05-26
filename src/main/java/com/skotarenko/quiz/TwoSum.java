package com.skotarenko.quiz;

import java.util.Arrays;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

 * @author maxyms
 *
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int p1 = 0, p2 = numbers.length - 1;
        int sum = 0;
        while (p2 > p1) {
            sum = numbers[p1] + numbers[p2];
            if (sum == target) {
                return new int[] { p1 + 1, p2 + 1 };
            } else if (sum > target) {
                ;
                p2--;
            } else {
                p1++;
            }
        }
        return new int[] {};
    }

    public int[] twoSum1(int[] numbers, int target) {
        int l = numbers.length;
        for (int i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] { i + 1, j + 1 };
                }
            }
        }
        return new int[] {};
    }
}
