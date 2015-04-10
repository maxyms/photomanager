package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {
    @Test
    public void testBasicAssignment() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        Assert.assertEquals(3, new BinaryTree().size(root));
    }

    @Test
    public void testInsert() {
        BinaryTree inst = new BinaryTree();
        TreeNode root = null;
        root = inst.insert(root, 2);
        root = inst.insert(root, 1);
        root = inst.insert(root, 3);
        root = inst.insert(root, 8);
        root = inst.insert(root, 6);
        root = inst.insert(root, 4);
        Assert.assertEquals(6, inst.size(root));
    }

    @Test
    public void testSizeNull() {
        Assert.assertEquals(0, new BinaryTree().size(null));
    }

    @Test
    public void testMaxDepth() {
        BinaryTree inst = new BinaryTree();
        TreeNode root = null;
        root = inst.insert(root, 2);
        root = inst.insert(root, 1);
        root = inst.insert(root, 3);
        root = inst.insert(root, 8);
        root = inst.insert(root, 6);
        root = inst.insert(root, 4);
        Assert.assertEquals(5, inst.maxDepth(root));
    }
}
