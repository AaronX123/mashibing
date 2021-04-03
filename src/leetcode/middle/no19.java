package leetcode.middle;

import leetcode.ListNode;

public class no19 {
    // 常规做法，先扫一遍获取链表长度，再计算第K个位置的节点进行删除, O(2N) = O(N)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        count = count - n;
        cur = head;
        if (count == 0) {
            head = cur.next;
            return head;
        }
        while (count > 1) {
            count--;
            cur = cur.next;
        }
        removeNode(cur, cur.next);
        return head;
    }

    private void removeNode(ListNode prev, ListNode node) {
        prev.next = node.next;
        node.next = null;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        new no19().removeNthFromEnd2(n1, 1);
    }

    // 有个指针先走n步，走n + 1步时后面指针才开始走，当第一个指针走完时，第二个指针恰好到倒数第n个节点的位置 O(N)
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (n <= 0 || head == null) return head;
        ListNode firstNode = head;
        ListNode latter = head;
        // 让快指针先走n步，如果此时走到末尾，说明head应该被删除
        while (n > 0 && firstNode != null) {
            firstNode = firstNode.next;
            n--;
        }
        if (firstNode == null) {
            head = head.next;
            return head;
        }
        while (firstNode.next != null) {
            firstNode = firstNode.next;
            latter = latter.next;
        }
        // 删除latter + 1对应的节点
        latter.next = latter.next.next;
        return head;
    }
}
