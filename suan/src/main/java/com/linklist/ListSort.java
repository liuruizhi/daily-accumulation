/*
 * Copyright (c) 2019.
 */

package com.linklist;

/**
 * 排序列表（归并排序）
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2:
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author liuruizhi
 * @since 2019/7/12
 */
public class ListSort {

    public ListNode listSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode faster = head.next;
        // 通过快慢指针确定中位
        while (faster != null && faster.next != null) {
            slow = slow.next;
            faster = faster.next.next;
        }

        ListNode tmp = slow.next;  // 右端起点
        slow.next = null;

        ListNode left = listSort(head);
        ListNode right = listSort(tmp);

        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }

            h = h.next;
        }

        h.next = left == null ? right : left;

        return res.next;
    }
}
