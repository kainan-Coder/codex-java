package com.uaian.algorithms.list;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l == r)
            return lists[l];

        if (l > r)
            return null;

        int mid = (l + r) / 2;
        ListNode l1 = mergeKLists(lists, l, mid);
        ListNode l2 = mergeKLists(lists, mid + 1, r);

        return mergeTwoList(l1, l2);
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
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
