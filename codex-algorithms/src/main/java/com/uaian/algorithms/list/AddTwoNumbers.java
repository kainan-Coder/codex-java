package com.uaian.algorithms.list;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode hair = new ListNode();
        ListNode pre = hair;
        int flag = 0;
        while (l1 != null && l2 != null){
            int val = l1.val + l2.val + flag;
            pre.next = new ListNode(val % 10);
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
            flag = val / 10;
        }
        while (l1 != null){
            int val = l1.val + flag;
            pre.next = new ListNode(val % 10);
            pre = pre.next;
            l1 = l1.next;
            flag = val / 10;
        }
        while (l2 != null){
            int val = l2.val + flag;
            pre.next = new ListNode(val % 10);
            pre = pre.next;
            l2 = l2.next;
            flag = val / 10;
        }
        if(flag != 0){
            pre.next = new ListNode(1);
        }
        return hair.next;
    }
}
