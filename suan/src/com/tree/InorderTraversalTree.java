package com.tree;

import java.util.ArrayList;
import java.util.List;

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
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }

        return res;
    }
}
