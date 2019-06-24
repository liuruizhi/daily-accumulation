/*
 * Copyright (c) 2019.
 */

package com.tree;

/**
 * 根节点到叶子节点之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * @author liuruizhi
 * @since 2019/6/21
 */
public class TreeSum {

    public int sum(TreeNode root, int preNum) {
        if (null == root) {
            return 0;
        }
        preNum = preNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return preNum;
        }

        return sum(root.left, preNum) + sum(root.right, preNum);
    }
}
