/*
 * Copyright (c) 2019.
 */

package com.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 *
 * @author liuruizhi
 * @since 2019/6/25
 */
public class TreeMaxDepth {

    // 非递归（DFS）
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 存储层结点
        Queue<TreeNode> queue = new LinkedList<>();

        int preCount = 1; // 当前层结点数量
        int pCount = 0;  // 下前层结点数量

        int level = 0;

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            preCount--;
            if (node.left != null) {
                queue.offer(node.left);
                pCount++;
            }

            if (node.right != null) {
                queue.offer(node.right);
                pCount++;
            }

            // preCount为0表示当前层已遍历完成
            if (preCount == 0) {
                preCount = pCount;
                pCount = 0;
                level++;
            }
        }

        return level;
    }

    // 递归实现
    public int traversal(TreeNode root) {

        return root == null ? 0 : Math.max(traversal(root.left), traversal(root.right)) + 1;
    }
}
