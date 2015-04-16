package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayTest {
    @Test
    public void removeDuplicatesElement2() {
        int[] arr = new int[] { 1, 1, 2, 3, 3, 4 };
        int[] exp = new int[] { 1, 2, 3, 4 };
        int newLen = new RemoveDuplicatesFromSortedArray().removeDuplicates(arr);
        validate(exp, arr, newLen);
    }

    @Test
    public void removeElementEmpty() {
        int[] arr = new int[] {};
        int[] exp = new int[] {};
        int newLen = new RemoveDuplicatesFromSortedArray().removeDuplicates(arr);
        validate(exp, arr, newLen);
    }

    @Test
    public void removeElementNoDuplicates() {
        int[] arr = new int[] { 1, 3, 5, 7, 8, 9 };
        int[] exp = new int[] { 1, 3, 5, 7, 8, 9 };
        int newLen = new RemoveDuplicatesFromSortedArray().removeDuplicates(arr);
        validate(exp, arr, newLen);
    }

    @Test
    public void removeElementAll() {
        int[] arr = new int[] { 1, 1, 2, 2, 3, 3 };
        int[] exp = new int[] { 1, 2, 3 };
        int newLen = new RemoveDuplicatesFromSortedArray().removeDuplicates(arr);
        validate(exp, arr, newLen);
    }

    private void validate(int[] exp, int[] arr, int newLen) {
        Assert.assertEquals(exp.length, newLen);
        for (int i = 0; i < newLen; i++) {
            Assert.assertEquals(exp[i], arr[i]);
        }
    }
}
