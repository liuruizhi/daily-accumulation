package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.

 * For example:
 * Given binary tree [1,null,2,3],
 *
 * return [1,3,2].
 *
 * @author liuruizhi
 * @since 2017/12/28
 */
public class InorderTraversalTree {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        hepler(root, res);

        return res;
    }

    public void hepler(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                hepler(root.left, res);
            }
            res.add(root.val);

            if (root.right != null) {
                hepler(root.right, res);
            }
        }
    }

    // -----------new data structure-Threaded Binary Tree----------

    /**
     * 引用：https://www.cnblogs.com/TenosDoIt/p/3445449.html
     * 重复以下1、2直到当前结点为空。
     * 1. 如果当前结点的左孩子为空，则输出当前结点并将其右孩子作为当前结点。
     * 2. 如果当前结点的左孩子不为空，在当前结点的左子树中找到当前结点在中序遍历下的前驱结点（即当前结点的左子树的最右结点）。
     *   a) 如果前驱结点的右孩子为空，将它（前驱结点）的右孩子设置为当前结点（利用这个空的右孩子指向它的后缀）。当前结点更新为当前结点的左孩子。
     *   b) 如果前驱结点的右孩子为当前结点，将它的右孩子重新设为空（恢复树的形状）。输出当前结点。当前结点更新为当前结点的右孩子。
     *
     * @param root
     * @return
     */

    public List<Integer> inorderTraversalNew(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        TreeNode curr = root;
        TreeNode pre;

        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }

            }
        }

        return res;
    }

    public List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            if (curr != null && curr.left != null) {
                stack.push(curr.left);
                curr = curr.left;
            } else {
                curr = stack.pop();
                res.add(curr.val);
                if (curr.right != null) {
                    stack.push(curr.right);
                    curr = curr.right;
                } else {
                    curr = null;
                }
            }
        }

        return res;
    }
}
