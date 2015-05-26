package com.skotarenko.quiz;

/**
 * Helper class for LinkedList problems
 * 
 * @author maxyms
 *
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "" + val + (next != null ? "->" + next.toString() : "");
    }
}