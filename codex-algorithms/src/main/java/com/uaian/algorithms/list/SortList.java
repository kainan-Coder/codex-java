package com.uaian.algorithms.list;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode listSecondHead = slow.next;
        slow.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(listSecondHead);

        return mergerList(l1, l2);
    }

    private ListNode mergerList(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        ListNode hair = new ListNode();
        ListNode pre = hair;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                ListNode next = l1.next;
                pre.next = l1;
                pre = l1;
                l1 = next;
            }else {
                ListNode next = l2.next;
                pre.next = l2;
                l2.next = null;
                pre = l2;
                l2 = next;
            }
        }
        if(l1 != null){
            pre.next = l1;
        }
        if(l2 != null){
            pre.next = l2;
        }
        return hair.next;
    }
}
