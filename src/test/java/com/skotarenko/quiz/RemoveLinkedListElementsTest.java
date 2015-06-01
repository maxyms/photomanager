package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class RemoveLinkedListElementsTest {
    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        ListNode e = head;
        e.next = new ListNode(2);
        e = e.next;
        e.next = new ListNode(6);
        e = e.next;
        e.next = new ListNode(3);
        e = e.next;
        e.next = new ListNode(4);
        e = e.next;
        e.next = new ListNode(5);
        e = e.next;
        e.next = new ListNode(6);
        e = e.next;
        head = new RemoveLinkedListElements().removeElements(head, 6);
        Assert.assertEquals("1->2->3->4->5", head.toString());
    }

    @Test
    public void testNull() {
        ListNode head = null;
        head = new RemoveLinkedListElements().removeElements(head, 6);
        Assert.assertNull("Test null", head);
    }

    @Test
    public void test3() {
        ListNode head = new ListNode(1);
        ListNode e = head;
        e.next = new ListNode(2);
        e = e.next;
        e.next = new ListNode(6);
        e = e.next;
        e.next = new ListNode(3);
        e = e.next;
        e.next = new ListNode(4);
        e = e.next;
        e.next = new ListNode(5);
        e = e.next;
        e.next = new ListNode(6);
        e = e.next;
        head = new RemoveLinkedListElements().removeElements(head, 7);
        Assert.assertEquals("1->2->6->3->4->5->6", head.toString());
    }

    @Test
    public void test4() {
        ListNode head = new ListNode(1);
        ListNode e = head;
        e.next = new ListNode(2);
        e = e.next;
        e.next = new ListNode(6);
        e = e.next;
        e.next = new ListNode(3);
        e = e.next;
        e.next = new ListNode(4);
        e = e.next;
        e.next = new ListNode(5);
        e = e.next;
        e.next = new ListNode(6);
        e = e.next;
        head = new RemoveLinkedListElements().removeElements(head, 1);
        Assert.assertEquals("2->6->3->4->5->6", head.toString());
    }

    @Test
    public void testRemoveAll() {
        ListNode head = new ListNode(1);
        ListNode e = head;
        e.next = new ListNode(1);
        e = e.next;
        e.next = new ListNode(1);
        e = e.next;
        e.next = new ListNode(1);
        e = e.next;
        e.next = new ListNode(1);
        e = e.next;
        e.next = new ListNode(1);
        e = e.next;
        e.next = new ListNode(1);
        e = e.next;
        head = new RemoveLinkedListElements().removeElements(head, 1);
        Assert.assertNull(head);
    }

    @Test
    public void testRemoveSequential() {
        ListNode head = new ListNode(1);
        ListNode e = head;
        e.next = new ListNode(2);
        e = e.next;
        e.next = new ListNode(2);
        e = e.next;
        e.next = new ListNode(1);
        e = e.next;
        head = new RemoveLinkedListElements().removeElements(head, 2);
        Assert.assertEquals("1->1", head.toString());
    }
}
