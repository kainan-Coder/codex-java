package com.uaian.algorithms.list;

public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head, second = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == null){
                return null;
            }
            if(fast == slow){
                while (second != fast){
                    second = second.next;
                    fast = fast.next;
                }
                return second;
            }
        }
        return null;
    }
}
