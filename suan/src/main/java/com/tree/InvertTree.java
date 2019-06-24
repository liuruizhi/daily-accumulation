/*
 * Copyright (c) 2019.
 */

package com.tree;

/**
 * 翻转一棵二叉树。
 *
 * @author liuruizhi
 * @since 2019/6/24
 */
public class InvertTree {

    public TreeNode preInvertTree(TreeNode root) {

        if (null == root) {
            return null;
        }
        TreeNode rightNode = root.getRight();
        root.right = preInvertTree(root.getLeft());
        root.left = preInvertTree(rightNode);

        return root;
    }

    public TreeNode midInvertTree(TreeNode root) {

        if (null == root) {
            return null;
        }

        midInvertTree(root.left);
        TreeNode rightNode = root.getRight();
        root.right = root.getLeft();
        root.left = rightNode;
        midInvertTree(root.left);

        return root;
    }

    public TreeNode postInvertTree(TreeNode root) {

        if (null == root) {
            return null;
        }

        TreeNode left = postInvertTree(root.left);
        TreeNode right = postInvertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public TreeNode dsfInvertTree(TreeNode root) {

        return root;
    }
}
