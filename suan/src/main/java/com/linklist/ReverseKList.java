/*
 * Copyright (c) 2019.
 */

package com.linklist;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 说明 :
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liuruizhi
 * @since 2019/8/28
 */
public class ReverseKList {

    /**
     * 栈
     *
     * 作者：powcai
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup1(ListNode head, int k) {

        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;

        while (true) {
            int count = 0;
            ListNode tmp = head;

            // 分组存入队列
            if (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }

            // 所剩元素不足以构成一组
            if (count != k) {
                p.next = head;
                break;
            }

            // 逆序输出
            while (!stack.isEmpty()){
                p.next = stack.pop();
                p = p.next;
            }
            p.next = tmp; // tmp指向了待排序部分
            head = tmp;

        }

        return newHead.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode result = new ListNode(0);

        if (null == head) {
            return head;
        }

        result.next = head;
        ListNode pre = result;
        ListNode tail = result;

        while (true) {
            int count = 0;

            while (tail != null && count != k) {
                count++;
                tail = tail.next;
            }

            if (null == tail) {
                break;
            }

            ListNode nHead = pre.next;
            while (pre.next != tail) {
                ListNode cur = pre.next;
                pre.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }

            pre = nHead;
            tail = nHead;

        }

        return result.next;
    }

}
