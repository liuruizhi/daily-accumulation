package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树后序遍历
 *
 * @author liuruizhi
 * @since 2019/5/27
 */
public class PostOrderTree {

    private static List<Integer> result = new ArrayList<>();

    // 递归
    public static void recursion(TreeNode root) {
        if (null == root) {
            return;
        }

        if (root.left != null) {
            recursion(root.left);
        }

        if (root.right != null) {
            recursion(root.right);
        }

        result.add(root.val);

    }

    // 非递归
    public static void noRecursion(TreeNode root) {
        if (null == root) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        stack.push(root);

        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (null == prev || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if(prev == curr.left) {

                if (curr.right != null) {
                    stack.push(curr.right);
                }

            } else {
                stack.pop();
                result.add(curr.val);
            }

            prev = curr;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.setVal(1);
        TreeNode c11 = new TreeNode();
        c11.setVal(2);
        TreeNode c12 = new TreeNode();
        c12.setVal(3);
        TreeNode c21 = new TreeNode();
        c21.setVal(4);
        TreeNode c22 = new TreeNode();
        c22.setVal(5);
        TreeNode c23 = new TreeNode();
        c23.setVal(6);
        TreeNode c24 = new TreeNode();
        c24.setVal(7);

        root.left = c11;
        c11.left = c21;
        c11.right = c22;
        root.right = c12;
        c12.left = c23;
        c12.right = c24;

//        recursion(root);
        noRecursion(root);

        for (Integer val : result) {
            System.out.print(val + " ");
        }
    }

}

