package leetcode.easy;

import leetcode.ListNode;

import java.util.ArrayList;

public class no234 {

    // 暴力做法
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            arrayList.add(cur.val);
            cur = cur.next;
        }
        for (int i = 0, j = arrayList.size() - 1; i < arrayList.size(); i++, j--) {
            if (i <= j) {
                if (arrayList.get(i) != arrayList.get(j)) return false;
            }
        }
        return true;
    }

    // 先用快慢指针找到中间节点，再将中间位置后的链表进行翻转，从头开始匹配，匹配完成后恢复链表
    public boolean isPalindrome2(ListNode head) {
        ListNode cur = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            cur = cur.next;
            fast = fast.next.next;
        }
        ListNode midNode = cur;
        ListNode midCur = reverse(midNode.next);
        // 匹配
        cur = head;
        while (midCur != null) {
            if (cur.val != midCur.val) return false;
            cur = cur.next;
            midCur = midCur.next;
        }
        // 还原
        reverse(midNode);
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
