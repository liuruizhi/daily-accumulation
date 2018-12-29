package com.linklist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.

 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 * @author liuruizhi
 * @since 2017/12/9
 */
public class SwapNodePairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h;
        ListNode node = head;
        while (node != null && node.next != null) {
            ListNode tmp = node.next.next;
            node.next.next = node;
            // node.next = tmp;
            pre.next = node.next;

            // if这块可以注掉，此处是让当前节点直接指向了交换后的节点，注掉了则更容易理解
            if(tmp!=null && tmp.next!=null)
                node.next = tmp.next;
            else
                node.next = tmp;
            pre = node;
            node = tmp;

        }

        return h.next;
    }
}
