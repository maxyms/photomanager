package com.skotarenko.quiz;

public class BinaryTree {
    public TreeNode insert(TreeNode node, int x) {
        if (node == null) {
            return new TreeNode(x);
        }
        if (node.val < x) {
            node.right = insert(node.right, x);
        } else {
            node.left = insert(node.left, x);
        }
        return node;
    }

    public int size(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return size(node.left) + 1 + size(node.right);
    }

    /**
     *  Given a binary tree, find its maximum depth.

         The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    *
    */
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
}
