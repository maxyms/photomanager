package com.skotarenko.quiz;

/**
 * Remove all elements from a linked list of integers that have value val.

    Example
    Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
    Return: 1 --> 2 --> 3 --> 4 --> 5

 * @author maxyms
 *
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = head;
        while (newHead != null && newHead.val == val) {
            newHead = newHead.next;
        }
        ListNode e = newHead;
        while (e != null && e.next != null) {
            if (e.next.val == val) {
                e.next = e.next.next;
            }else{
            e = e.next;
            }
        }
        return newHead;
    }
}
