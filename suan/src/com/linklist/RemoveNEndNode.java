package com.linklist;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

 * For example,

 * Given linked list: 1->2->3->4->5, and n = 2.

 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 * @author liuruizhi
 * @since 2017/12/8
 */
public class RemoveNEndNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0);

        node.next = head;

        ListNode first = node;
        ListNode second = node;

        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return node.next;
    }
}
