/*
 * Copyright (c) 2019.
 */

package com.tree;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * 即左子树高度+右子树高度
 * @author liuruizhi
 * @since 2019/7/29
 */
public class DiameterTree {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        depth(root);

        return max;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);

        if (left + right > 0) {
            max = left + right;
        }

        return Math.max(left, right) + 1;
    }
}
