/*
 * Copyright (c) 2019.
 */

package com.linklist;

/**
 * 算法
 * Floyd 的算法被划分成两个不同的 阶段 。在第一阶段，找出列表中是否有环，如果没有环，可以直接返回 null 并退出。否则，用 相遇节点 来找到环的入口。
 * 阶段 1
 * 这里我们初始化两个指针 - 快指针和慢指针。我们每次移动慢指针一步、快指针两步，直到快指针无法继续往前移动。如果在某次移动后，快慢指针指向了同一个节点，我们就返回它。否则，我们继续，直到 while 循环终止且没有返回任何节点，这种情况说明没有成环，我们返回 null 。
 *
 * 阶段 2
 * 给定阶段 1 找到的相遇点，阶段 2 将找到环的入口。首先我们初始化额外的两个指针： ptr1 ，指向链表的头， ptr2 指向相遇点。然后，我们每次将它们往前移动一步，直到它们相遇，它们相遇的点就是环的入口，返回这个节点。
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/huan-xing-lian-biao-ii-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author liuruizhi
 * @since 2019/8/5
 */
public class CycleLinkListAccess {

    public ListNode cycleNode(ListNode node) {

        ListNode slow = node;
        ListNode fast = node.next;

        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return slow;
            }
        }

        return null;
    }

    public ListNode detectCycle(ListNode head) {

        if (null == head) {
            return null;
        }

        ListNode cycle = cycleNode(head);

        if (null == cycle) {
            return null;
        }

        ListNode pre = head;
        ListNode part2 = cycle;
        while (pre != part2) {
            pre = pre.next;
            part2 = part2.next;
        }

        return pre;
    }
}
