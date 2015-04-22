package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortedArrayTest {
    @Test
    public void merge() {
        int[] A = new int[] { 1, 2, 5, 7, 8, 0, 0, 0, 0 };
        int[] B = new int[] { 2, 4, 6, 7 };
        int[] exp = new int[] { 1, 2, 2, 4, 5, 6, 7, 7, 8 };
        new MergeSortedArray().merge(A, 5, B, 4);
        for (int i = 0; i < exp.length; i++) {
            Assert.assertEquals(exp[i], A[i]);
        }
    }

    @Test
    public void mergeEqual() {
        int[] A = new int[] { 1, 2, 5, 7, 8, 0, 0, 0, 0, 0 };
        int[] B = new int[] { 1, 2, 5, 7, 8 };
        int[] exp = new int[] { 1, 1, 2, 2, 5, 5, 7, 7, 8, 8 };
        new MergeSortedArray().merge(A, 5, B, 5);
        for (int i = 0; i < exp.length; i++) {
            Assert.assertEquals(exp[i], A[i]);
        }
    }

    @Test
    public void mergeEmptyA() {
        int[] A = new int[] { 0, 0, 0, 0, 0 };
        int[] B = new int[] { 1, 2, 5, 7, 8 };
        int[] exp = new int[] { 1, 2, 5, 7, 8 };
        new MergeSortedArray().merge(A, 0, B, 5);
        for (int i = 0; i < exp.length; i++) {
            Assert.assertEquals(exp[i], A[i]);
        }
    }

    @Test
    public void mergeEmptyB() {
        int[] A = new int[] { 1, 2, 5, 7, 8, 0, 0, 0, 0 };
        int[] B = new int[] {};
        int[] exp = new int[] { 1, 2, 5, 7, 8, 0, 0, 0, 0 };
        new MergeSortedArray().merge(A, 5, B, 0);
        for (int i = 0; i < exp.length; i++) {
            Assert.assertEquals(exp[i], A[i]);
        }
    }
}
