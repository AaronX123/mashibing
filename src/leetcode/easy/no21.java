package leetcode.easy;

import leetcode.ListNode;

public class no21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null, cur = null;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                if (head == null) {
                    head = l2;
                    cur = head;
                } else {
                    cur.next = l2;
                    cur = cur.next;
                }
                l2 = l2.next;
            } else {
                if (head == null) {
                    head = l1;
                    cur = head;
                } else {
                    cur.next = l1;
                    cur = cur.next;
                }
                l1 = l1.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        System.out.println(new no21().mergeTwoLists(l11,l21));
    }
}
