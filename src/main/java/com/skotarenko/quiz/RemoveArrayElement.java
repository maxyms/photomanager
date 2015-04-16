package com.skotarenko.quiz;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.

    The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * @author maxyms
 *
 */
public class RemoveArrayElement {
    public int removeElement(int[] A, int elem) {
        int p = A.length - 1;
        int i = -1;
        while (++i <= p) {
            while (A[i] == elem && i <= p) {
                A[i] = A[p--];
            }
        }
        return p + 1;
    }
}
