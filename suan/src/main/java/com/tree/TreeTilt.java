/*
 * Copyright (c) 2019.
 */

package com.tree;

/**
 * 二叉树坡度
 * 给定一个二叉树，计算整个树的坡度。
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liuruizhi
 * @since 2019/8/5
 */
public class TreeTilt {
    private int tilt = 0;
    public int findTilt(TreeNode root) {
        traverse(root);

        return tilt;
    }

    public int traverse(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);

        tilt = tilt + Math.abs(left - right);

        return left + right + root.val;
    }
}
