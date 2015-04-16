package com.skotarenko.quiz;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.

    You may assume that the array is non-empty and the majority element always exist in the array.

 * @author maxyms
 *
 */
public class MajorityElement {
    public int majorityElement(int[] num) {
        int expectedCount = Math.round(((float) num.length) / 2);
        int pointer = num.length - 1;
        int count = 0;
        int cur = 0;
        while (pointer >= 0) {
            cur = num[0];
            count = 1;
            for (int i = 1; i <= pointer; i++) {
                while (num[i] == cur && i <= pointer) {
                    count++;
                    num[i] = num[pointer];
                    pointer--;
                }
                if (count >= expectedCount) {
                    return cur;
                }
            }
            if (count >= expectedCount) {
                return cur;
            }
            num[0] = num[pointer];
            pointer--;
        }
        return -1;
    }
}
