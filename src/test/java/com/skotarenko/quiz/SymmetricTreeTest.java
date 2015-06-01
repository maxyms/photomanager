package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class SymmetricTreeTest {
    @Test
    public void testSymmetric() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        Assert.assertTrue("Tree is suppose to be symmetric", new SymmetricTree().isSymmetric(root));
    }

    @Test
    public void testNonSymmetric() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        Assert.assertFalse("Tree is suppose to be not symmetric", new SymmetricTree().isSymmetric(root));
    }
}
