/*
 * Copyright (c) 2019.
 */

package com.tree;

/**
 * 关于复杂度
 * 1.1 时间复杂度为O(n)
 * 1.2 空间负责度为O(1)
 * 我的解题思路
 * 2.1 因为题目指出待遍历的树是二叉搜索树，所以中序遍历结果肯定为有序数组
 * 2.2 因为题目要求求出结点的最小距离，所以这个距离肯定发生在相邻结点之间
 * 2.3 定义两个变量记录遍历过程对比结果
 * 2.4 中序遍历二叉树，对比当前结点与上一结点的差与当前最小距离，并根据对比结果适当调整变量的值
 * 提交记录
 * 3.1 力扣中耗时1ms,消耗35MB内存
 * 3.2 leetcode中耗时0ms,消耗34.5MB内存
 *
 * 作者：cartoon
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/ji-lu-shang-ci-bian-li-jie-dian-de-zhong-xu-bian-l/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author liuruizhi
 * @since 2019/7/29
 */
public class MinDiffTree {

    private int min = Integer.MAX_VALUE;
    private int pre = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        depth(root);

        return min;
    }

    public void depth(TreeNode node) {
        if (node == null) {
            return;
        }

        depth(node.left);

        if (pre != Integer.MAX_VALUE) {
            min = Math.min(min, node.val - pre);
        }

        pre = node.val;

        depth(node.right);
    }
}
