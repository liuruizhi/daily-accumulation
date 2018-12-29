package com.linklist;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example

 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author liuruizhi
 * @since 2017/12/8
 */
class ListNode {
    protected ListNode next;
    protected int val;

    ListNode(int x) {
        this.val = x;
    }
}

public class AddTwoNumber {

    // 我的
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode newHead = null;
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode node = null;
        int step = 0;
        while (node1 != null || node2 != null || step != 0) {
            int sum = 0;
            if (node1 != null && node2 != null) {
                sum = node1.val + node2.val;

            } else if (node1 != null && node2 == null) {
                sum = node1.val;

            } else if (node2 != null && node1 == null){
                sum = node2.val;

            }
            sum = sum + step;
            int number = sum % 10;
            step = sum / 10;

            ListNode newNode = new ListNode(number);

            if (node1 == l1) {
                newHead = node = newNode;
                // node = newNode
                // newHead = node;
            } else {
                node.next = newNode;
                node = newNode;
            }

            if (node1 != null) {
                node1 = node1.next;
            }

            if (node2 != null) {
                node2 = node2.next;
            }
        }
        return newHead;
    }

    // 大神的
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode node = newHead;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int step = 0;

        while (p1 != null || p2 != null) {
            int x = p1 == null ? 0 : p1.val;
            int y = p2 == null ? 0 : p2.val;

            int sum = x + y + step;

            node.next = new ListNode(sum % 10);
            step = sum / 10;
            if (p1.next != null) {
                p1 = p1.next;
            }

            if (p2.next != null) {
                p2 = p2.next;
            }

        }

        if (step > 0) {
            node.next = new ListNode(step);
        }

        return newHead.next;
    }
}
