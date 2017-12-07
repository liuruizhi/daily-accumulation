package com.linklist;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 * http://blog.csdn.net/linhuanmars/article/details/22463599/
 *
 * @author liuruizhi
 * @since 2017/12/7
 */

class RandomListNode {
    protected RandomListNode next;
    protected RandomListNode random;
    protected int label;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class CopyListwithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }

        RandomListNode node = head;
        while(node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }
        node = head;

        while(node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }

        node = head;
        RandomListNode newHead = node.next;

        while(node != null) {
            RandomListNode tmp = node.next;
            node.next = tmp.next;
            if (tmp.next != null) {
                tmp.next = tmp.next.next;
            }
            node = node.next;

        }
        return newHead;
    }
}
