package com.uaian.algorithms.list;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode();
        hair.next = head;
        ListNode pre = hair;
        int index = 1;
        while (head != null){
            while (head != null && index < k){
                head = head.next;
                if(head == null){
                    return hair.next;
                }
                index++;
            }
            ListNode oldHead = pre.next;
            pre.next = null;
            ListNode next = head.next;
            head.next = null;
            ListNode[] res = reverseList(oldHead);
            pre.next = res[0];
            res[1].next = next;
            pre = res[1];
            index = 1;
            head = next;
        }
        return hair.next;
    }

    private ListNode[] reverseList(ListNode oldHead) {
        ListNode tailNew = oldHead;
        ListNode pre = null;
        while (oldHead != null){
            ListNode next = oldHead.next;
            oldHead.next = pre;
            pre = oldHead;
            oldHead = next;
        }
        return new ListNode[]{pre, tailNew};
    }
}
