/*
 * Copyright (c) 2019.
 */

package com.linklist;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 空间复杂度 O(1)O(1) 时间复杂度为 O(n)O(n)
 * 这里使用图解的方式，解释比较巧妙的一种实现。
 * 根据题目意思 如果两个链表相交，那么相交点之后的长度是相同的
 * 我们需要做的事情是，让两个链表从同距离末尾同等距离的位置开始遍历。这个位置只能是较短链表的头结点位置。 为此，我们必须消除两个链表的长度差
 *   指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
 *   如果 pA 到了末尾，则 pA = headB 继续遍历
 *   如果 pB 到了末尾，则 pB = headA 继续遍历
 *   比较长的链表指针指向较短链表head时，长度差就消除了
 * 如此，只需要将最短链表遍历两次即可找到位置

 * 作者：user7208t
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author liuruizhi
 * @since 2019/7/29
 */
public class IntersectionList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }

        return pA;
    }
}
