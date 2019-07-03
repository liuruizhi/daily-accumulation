/*
 * Copyright (c) 2019.
 */

package com.linklist;

/**
 * 反转单链表
 * 示例:
 *    输入: 1->2->3->4->5->NULL
 *    输出: 5->4->3->2->1->NULL
 *
 * @author liuruizhi
 * @since 2019/6/25
 */
public class ReverseList {

    // 非递归
    public ListNode reverseList(ListNode h) {
        if (h == null || h.next == null) {
            return h;
        }

        ListNode pre = null;
        ListNode curr = h;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

    // 递归
    public ListNode traversal(ListNode h) {
        if (h == null || h.next == null) {
            return h;
        }

        ListNode node = traversal(h.next);

        h.next.next = h;
        h.next = null;

        return node;
    }
}
