package com.skotarenko.quiz;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

    Note:
    You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

 * @author maxyms
 *
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        if (n == 0) {
            return;
        }
        int tmp = 0;
        for (int i = m; i < m + n; i++) {
            A[i] = B[i - m];
        }
        for (int i = 0; i < m; i++) {
            if (A[i] > A[m]) {
                tmp = A[i];
                A[i] = A[m];
                A[m] = tmp;
                int p1 = m;
                while (p1 < m + n - 1 && A[p1] > A[++p1]) {
                    tmp = A[p1];
                    A[p1] = A[p1 - 1];
                    A[p1 - 1] = tmp;
                }
            }
        }
    }
}
