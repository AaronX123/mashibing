package leetcode.easy;

import leetcode.ListNode;

public class no141 {
    public boolean isCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow, fast;
        slow = head;
        fast = head.next;
        // 快指针每次走2格
        while (fast != slow) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
