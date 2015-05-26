package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class SameTreeTest {
    @Test
    public void testEqual() {
        TreeNode p = new TreeNode(2);
        p.left = new TreeNode(1);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(2);
        q.left = new TreeNode(1);
        q.right = new TreeNode(3);
        Assert.assertTrue("Trees are not equal", new SameTree().isSameTree(p, q));
    }

    @Test
    public void testNotEqualValue() {
        TreeNode p = new TreeNode(2);
        p.left = new TreeNode(1);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(3);
        q.left = new TreeNode(1);
        q.right = new TreeNode(3);
        Assert.assertFalse("Trees are not equal", new SameTree().isSameTree(p, q));
    }

    @Test
    public void testNotEqualStructure() {
        TreeNode p = new TreeNode(2);
        p.left = new TreeNode(1);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(2);
        q.left = new TreeNode(1);
        q.right = new TreeNode(3);
        q.left.left = new TreeNode(5);
        Assert.assertFalse("Trees are not equal", new SameTree().isSameTree(p, q));
    }

    @Test
    public void testNotEqualNull() {
        TreeNode p = new TreeNode(2);
        p.left = new TreeNode(1);
        p.right = new TreeNode(3);
        Assert.assertFalse("Trees are equal", new SameTree().isSameTree(p, null));
    }

    @Test
    public void testEqualBothNull() {
        Assert.assertTrue("Trees are not equal", new SameTree().isSameTree(null, null));
    }
}
