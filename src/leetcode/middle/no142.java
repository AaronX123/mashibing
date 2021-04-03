package leetcode.middle;

import leetcode.ListNode;

import java.util.HashSet;

public class no142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)) return cur;
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }
}
