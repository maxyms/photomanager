package com.skotarenko.quiz;

/**
 * Given a binary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    
 * @author maxyms
 *
 */
public class BinaryTreeDepth {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        TreeNode node = root;
        while (node.left != null || node.right != null) {
        }
        return 0;
    }

    public static void main(String[] args) {
        BinaryTreeDepth binTree = new BinaryTreeDepth();
        TreeNode root = new TreeNode(10);
        binTree.maxDepth(root);
    }
}
