/*
 * Copyright (c) 2019.
 */

package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 检查一颗二叉树是否左右对称
 *
 * @author liuruizhi
 * @since 2019/7/25
 */
public class TreeIsSymmetric {

    public static boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);

        }

        return true;
    }

    public static boolean isSymmetric2(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;

        TreeNode l1 = new TreeNode();
        l1.val = 2;

        TreeNode r1 = new TreeNode();
        r1.val = 2;

        TreeNode l2 = new TreeNode();
        l2.val = 3;

        TreeNode r2 = new TreeNode();
        r2.val = 4;

        TreeNode l3 = new TreeNode();
        l3.val = 4;

        TreeNode r3 = new TreeNode();
        r3.val = 3;

        root.left = l1;
        root.right = r1;

        l1.left = l2;
        l1.right = r2;

        r1.left = l3;
        r1.right = r3;

        boolean result = isSymmetric(root);
        System.out.println(result);
    }
}
