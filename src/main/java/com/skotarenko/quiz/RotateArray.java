package com.skotarenko.quiz;

import java.util.Arrays;

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
        int tmp = 0, p = 0, l = nums.length;
        if ((l == 0) || (k = k % l) == 0) {
            return;
        }
        System.out.println(Arrays.toString(nums));
        while (p < l - k) {
            System.out.println("Next iteration");
            for (int i = p; i < p + k; i++) {
                tmp = nums[i];
                nums[i] = nums[l - k + (i - p)];
                nums[l - k + (i - p)] = tmp;
                System.out.println(Arrays.toString(nums));
            }
            p += k;
        }
        int newK = 2 * k - l;
        int newL = 2 * l - 3 * k;
        p = l - k;
        k = newK;
        l = newL;
        while (p < l - k) {
            System.out.println("Next iteration");
            for (int i = p; i < p + k; i++) {
                tmp = nums[i];
                nums[i] = nums[l - k + (i - p)];
                nums[l - k + (i - p)] = tmp;
                System.out.println(Arrays.toString(nums));
            }
            p += k;
        }
    }

    public void rotate4(int[] nums, int k) {
        int tmp = 0, p = 0, l = nums.length;
        if ((l == 0) || (k = k % l) == 0) {
            return;
        }
        if (l % k == 0) {
            for (int j = 0; j < k; j++) {
                int index = l - 1;
                int elem = nums[index];
                int newInd = j;
                for (int i = 0; i < l / k; i++) {
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
        } else {
            int index = l - 1;
            int elem = nums[index];
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
        System.out.println(Arrays.toString(nums));
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
