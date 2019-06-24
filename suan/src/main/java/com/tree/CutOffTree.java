package com.tree;

import java.util.*;

/**
 * 给定一颗二叉树 每一个节点具有不同的值, 和一个目标值 k, 在树中找到距离目标 k最近的节点 .如果存在多个这样的节点, 返回 靠近左侧的那一个.
 *
 * Created by liuruizhi on 2019/5/27.
 */
public class CutOffTree {

    private TreeNode target;
    private Map<TreeNode, TreeNode> order = new HashMap<>();

    public void tree(TreeNode node, int k) {
        if (null == node) {
            return;
        }

        if (k == node.getVal()) {
            target = node;
            return;
        }

        TreeNode left = node.getLeft();
        TreeNode right = node.getRight();

        if (null != right) {
            order.put(right, node);
            tree(right, k);
        }

        if (null != left) {
            order.put(left, node);
            tree(left, k);
        }
    }

    public int findPath(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        tree(root, k);

        List<TreeNode> list = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        list.add(root);
        visited.add(root);

        while (!list.isEmpty()) {
            TreeNode rem = list.remove(0);

            if (rem.getLeft() == null && rem.getRight() == null) {
                return rem.getVal();
            }

            if (rem.getLeft() != null && !visited.contains(rem.getLeft())) {
                list.add(rem.getLeft());
                visited.add(rem.getLeft());
            }

            if (rem.getRight() != null && !visited.contains(rem.getRight())) {
                list.add(rem.getRight());
                visited.add(rem.getRight());
            }

            TreeNode parent = order.get(rem);

            if (parent != null && !visited.contains(parent)) {
                list.add(parent);
                visited.add(parent);
            }
        }

        return -1;
    }
}
