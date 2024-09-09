package com.uaian.algorithms.list;

public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode pre = hair;
        int index = 1;
        while (head != null && index < left){
            head = head.next;
            pre = pre.next;
            index++;
        }
        ListNode tempHead = head;
        while (head != null && index < right){
            head = head.next;
            index++;
        }
        ListNode next = head.next;
        head.next = null;
        pre.next = null;
        ListNode[] nodes = reserveList(tempHead);
        pre.next = nodes[0];
        nodes[1].next = next;
        return hair.next;
    }

    private ListNode[] reserveList(ListNode head) {
        ListNode newTail = head;
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return new ListNode[]{pre, newTail};
    }
}
