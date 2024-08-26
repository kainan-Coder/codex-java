package com.uaian.algorithms.list;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode hair = new ListNode();
        ListNode pre = hair;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                ListNode next = list1.next;
                pre.next = list1;
                pre = list1;
                list1 = next;
            }else {
                ListNode next = list2.next;
                pre.next = list2;
                pre = list2;
                list2 = next;
            }
        }
        if(list1 != null)
            pre.next = list1;
        if(list2 != null)
            pre.next = list2;
        return hair.next;
    }
}
