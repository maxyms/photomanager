package com.skotarenko.quiz;

public class BinaryTree123 {
    private TreeNode build123_1() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        return root;
    }

    private TreeNode build123_2() {
        TreeNode root = null;
        root = insert(root, 2);
        root = insert(root, 1);
        root = insert(root, 3);
        root = insert(root, 8);
        root = insert(root, 6);
        root = insert(root, 4);
        return root;
    }

    private TreeNode insert(TreeNode node, int x) {
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

    private int size(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return size(node.left) + 1 + size(node.right);
    }

    private int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public static void main(String[] args) {
        BinaryTree123 inst = new BinaryTree123();
        inst.build123_1();
        TreeNode root = inst.build123_2();
        System.out.println(inst.size(null));
        //
        TreeNode root2 = inst.insert(null, 2);
        System.out.println(inst.size(root2));
        //
        int size = inst.size(root);
        System.out.println("Size=" + size);
        ///
        int maxDepth = inst.maxDepth(root);
        System.out.println("Max Depth=" + maxDepth);
    }
}
