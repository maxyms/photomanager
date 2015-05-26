package com.skotarenko.quiz;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n = " + n);
        }
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        if (p2 == null) {
            head = p1.next;
        } else {
            while (p2.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            p1.next = p1.next.next;
        }
        return head;
    }
}
