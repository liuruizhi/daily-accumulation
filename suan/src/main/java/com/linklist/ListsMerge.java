/*
 * Copyright (c) 2019.
 */

package com.linklist;

/**
 * 两个有序链表合并
 *
 * @author liuruizhi
 * @since 2019/7/1
 */
public class ListsMerge {

    public ListNode mergeList(ListNode l1, ListNode l2) {

        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return preHead.next;
    }
}
