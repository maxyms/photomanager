package com.skotarenko.quiz;

import org.junit.Assert;
import org.junit.Test;

public class RemoveNthNodeFromEndOfListTest {
    @Test
    public void test2of5() {
        ListNode head = new ListNode(1);
        ListNode e = head;
        for (int i = 2; i <= 5; i++) {
            ListNode next = new ListNode(i);
            e.next = next;
            e = next;
        }
        int n = 2;
        head = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, n);
        Assert.assertEquals("1->2->3->5", head.toString());
    }

    @Test
    public void test6of15() {
        ListNode head = new ListNode(1);
        ListNode e = head;
        for (int i = 2; i <= 15; i++) {
            ListNode next = new ListNode(i);
            e.next = next;
            e = next;
        }
        int n = 6;
        head = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, n);
        Assert.assertEquals("1->2->3->4->5->6->7->8->9->11->12->13->14->15", head.toString());
    }

    @Test
    public void testFirst() {
        ListNode head = new ListNode(1);
        ListNode e = head;
        for (int i = 2; i <= 15; i++) {
            ListNode next = new ListNode(i);
            e.next = next;
            e = next;
        }
        int n = 15;
        head = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, n);
        Assert.assertEquals("2->3->4->5->6->7->8->9->10->11->12->13->14->15", head.toString());
    }

    @Test
    public void testLast() {
        ListNode head = new ListNode(1);
        ListNode e = head;
        for (int i = 2; i <= 15; i++) {
            ListNode next = new ListNode(i);
            e.next = next;
            e = next;
        }
        int n = 1;
        head = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, n);
        Assert.assertEquals("1->2->3->4->5->6->7->8->9->10->11->12->13->14", head.toString());
    }

    @Test
    public void test1of2() {
        ListNode head = new ListNode(1);
        ListNode e = head;
        for (int i = 2; i <= 2; i++) {
            ListNode next = new ListNode(i);
            e.next = next;
            e = next;
        }
        int n = 1;
        head = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, n);
        Assert.assertEquals("1", head.toString());
    }
}
