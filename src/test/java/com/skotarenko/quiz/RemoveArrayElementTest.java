package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class RemoveArrayElementTest {
    @Test
    public void removeElement2() {
        int[] arr = new int[] { 1, 2, 3, 2, 1 };
        int elem = 2;
        int newLen = new RemoveArrayElement().removeElement(arr, elem);
        Assert.assertEquals(3, newLen);
        for (int i = 0; i < newLen; i++) {
            Assert.assertNotEquals(elem, arr[i]);
        }
    }

    @Test
    public void removeElementEmpty() {
        int[] arr = new int[] {};
        int elem = 2;
        int newLen = new RemoveArrayElement().removeElement(arr, elem);
        Assert.assertEquals(0, newLen);
        for (int i = 0; i < newLen; i++) {
            Assert.assertNotEquals(elem, arr[i]);
        }
    }

    @Test
    public void removeElementNo() {
        int[] arr = new int[] { 1, 2, 3, 2, 1 };
        int elem = 5;
        int newLen = new RemoveArrayElement().removeElement(arr, elem);
        Assert.assertEquals(5, newLen);
        for (int i = 0; i < newLen; i++) {
            Assert.assertNotEquals(elem, arr[i]);
        }
    }

    @Test
    public void removeElementAll() {
        int[] arr = new int[] { 1, 1, 1, 1, 1 };
        int elem = 1;
        int newLen = new RemoveArrayElement().removeElement(arr, elem);
        Assert.assertEquals(0, newLen);
        for (int i = 0; i < newLen; i++) {
            Assert.assertNotEquals(elem, arr[i]);
        }
    }

    @Test
    public void removeElement6() {
        int[] arr = new int[] { 6, 1, 2, 6, 4, 6, 1, 1, 6 };
        int elem = 6;
        int newLen = new RemoveArrayElement().removeElement(arr, elem);
        Assert.assertEquals(5, newLen);
        for (int i = 0; i < newLen; i++) {
            Assert.assertNotEquals(elem, arr[i]);
        }
    }
}
