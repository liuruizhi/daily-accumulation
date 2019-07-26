/*
 * Copyright (c) 2019.
 */

package com.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树边界
 *
 * @author liuruizhi
 * @since 2019/7/26
 */
public class TreeEdge {

    public List<Integer> solution(TreeNode node) {

        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }

        result.add(node.val);
        helper(node.left, true, false, result);
        helper(node.right, false, true, result);

        return result;
    }

    public void helper(TreeNode node, boolean left, boolean right, List<Integer> res) {

        if (node == null) {
            return;
        }
        // 叶结点
        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }
        // 如果是左结点需要记录当前结点的值（如何判定跟结点的左子树？）
        if (left) {
            res.add(node.val);
        }

        helper(node.left, left && node.left != null, right && node.right == null, res);

        helper(node.right, left && node.left == null, right && node.right != null, res);

        if (right) {
            res.add(node.val);
        }

    }
}
