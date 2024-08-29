package com.uaian.algorithms.list;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null || curB != null){
            if(curA.next == null && curB.next == null){
                return null;
            }
            if(curA.next == curB.next){
                return curB.next;
            }
            curA = curA.next == null ? headB : curA.next;
            curB = curB.next == null ? headA : curB.next;

        }
        return null;
    }
}
