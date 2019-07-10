/*
 * Copyright (c) 2019.
 */

package com.tree;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liuruizhi
 * @since 2019/7/10
 */
public class TreeSumIII {

    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }

        return path(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);
    }

    public int path(TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }

        int res = 0;

        if (root.val == sum) {
            res++;
        }

        res += path(root.left, sum - root.val);
        res += path(root.right, sum - root.val);

        return res;
    }
}
