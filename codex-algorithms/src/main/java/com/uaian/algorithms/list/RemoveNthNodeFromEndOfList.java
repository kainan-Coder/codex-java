package com.uaian.algorithms.list;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode fast = head;
        ListNode slow = hair;
        int index = 0;
        while (index < n){
            fast = fast.next;
            index ++;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode next = slow.next.next;
        slow.next = next;
        return hair.next;
    }
}
