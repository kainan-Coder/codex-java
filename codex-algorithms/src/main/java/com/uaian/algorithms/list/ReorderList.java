package com.uaian.algorithms.list;

public class ReorderList {

    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode newHead = reserve(next);
        mergeTwoList(head, newHead);
    }

    private void mergeTwoList(ListNode head, ListNode newHead) {
        ListNode cur = head;
        while (cur != null && newHead != null){
            ListNode nextCur = cur.next;
            cur.next = newHead;
            ListNode nextSecond = newHead.next;
            newHead.next = nextCur;
            cur = nextCur;
            newHead = nextSecond;
        }
    }

    private ListNode reserve(ListNode head) {
        ListNode pre = null;
        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
