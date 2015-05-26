package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class ContainsDuplicateTest {
    @Test
    public void testContains() {
        int[] nums = new int[] { 1, 2, 5, 7, 12, 4, 1, 2, 4, 7, 5, 2, 6, 3, 5 };
        Assert.assertTrue("Duplicates not found", new ContainsDuplicate().containsDuplicate(nums));
    }

    @Test
    public void testNotContains() {
        int[] nums = new int[] { 1, 2, 5, 7, 12, 4, 31, 42, 54, 47, 55, 22, 6, 3, 225 };
        Assert.assertFalse("Duplicates found", new ContainsDuplicate().containsDuplicate(nums));
    }

    @Test
    public void testEmpty() {
        int[] nums = new int[] {};
        Assert.assertFalse("Duplicates found", new ContainsDuplicate().containsDuplicate(nums));
    }

    @Test(timeout = 100)
    public void testBruteForce() {
        int N = 50000;
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i;
        }
        Assert.assertFalse("Duplicates found", new ContainsDuplicate().containsDuplicate(nums));
    }

    @Test(timeout = 100)
    public void testBruteForceMap() {
        int N = 50000;
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i;
        }
        Assert.assertFalse("Duplicates found", new ContainsDuplicate().containsDuplicateMap(nums));
    }
}
