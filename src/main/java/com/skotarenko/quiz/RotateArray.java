package com.skotarenko.quiz;

public class RotateArray {
    public void rotate1(int[] nums, int k) {
        final int l = nums.length;
        k = k % l;
        int[] res = new int[l];
        int p = l - k;
        for (int i = 0; i < l; i++) {
            if (p < l) {
                res[i] = nums[p];
                p++;
            } else {
                res[i] = nums[i - k];
            }
        }
        for (int i = 0; i < l; i++) {
            nums[i] = res[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        final int l = nums.length;
        k = k % l;
        int cur = 0;
        for (int j = 0; j < k; j++) {
            cur = nums[l - 1];
            for (int i = l - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = cur;
        }
    }

    public void rotate3(int[] nums, int k) {
        final int l = nums.length;
        k = k % l;
        int index = l - 1;
        int elem = nums[index];
        int tmp = 0;
        int newInd = 0;
        for (int i = 0; i < l; i++) {
            newInd = index + k;
            if (newInd >= l) {
                newInd -= l;
            }
            tmp = nums[newInd];
            nums[newInd] = elem;
            elem = tmp;
            index = newInd;
        }
    }

    public void rotate4(int[] nums, int k) {
        final int l = nums.length;
        k = k % l;
        int index = l - 1;
        int elem = nums[index];
        int tmp = 0;
        int newInd = 0;
        for (int i = 0; i < l; i++) {
            newInd = index + k;
            if (newInd >= l) {
                newInd -= l;
            }
            tmp = nums[newInd];
            nums[newInd] = elem;
            elem = tmp;
            index = newInd;
        }
    }

    public void rotate(Object[] nums, int k) {
        final int l = nums.length;
        k = k % l;
        int index = l - 1;
        Object elem = nums[index];
        Object tmp = null;
        int newInd = 0;
        for (int i = 0; i < l; i++) {
            newInd = index + k;
            if (newInd >= l) {
                newInd -= l;
            }
            tmp = nums[newInd];
            nums[newInd] = elem;
            elem = tmp;
            index = newInd;
        }
    }
}
