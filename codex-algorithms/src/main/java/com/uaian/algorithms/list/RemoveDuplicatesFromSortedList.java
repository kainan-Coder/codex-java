package com.uaian.algorithms.list;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode pre = hair;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            while (next != null && next.val == cur.val){
                next = next.next;
            }

            if(cur.next != next){
                pre.next = next;
                cur = next;
            }else {
                pre = cur;
                cur = next;
            }
        }

        return hair.next;
    }
}
