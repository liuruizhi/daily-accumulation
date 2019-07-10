/*
 * Copyright (c) 2019.
 */

package com.tree;

/**
 * 二叉树转为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 左中右是按从小到大的遍历，所以右中左遍历就是从大到小，因此右中左遍历，比例过程中不断的加上原来的数就行了。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liuruizhi
 * @since 2019/7/9
 */
public class CumulativeTree {

    public TreeNode convertBST(TreeNode root) {

        search(root, 0);
        return root;
    }

    public int search(TreeNode root, int n) {

        if(root == null)
            return n;

        int right_val = search(root.right, n);

        //右中左的中序遍历，所以相加的操作只用在中间做就行了，其他的就是把参数传递到下一层
        root.val += right_val;

        int left_val = search(root.left, root.val);

        //这里是把左中右三个节点里最后一个遍历的左子节点的返回值，返回给下一层
        return left_val;

    }
}
