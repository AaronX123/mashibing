package leetcode.hard;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class no23 {
    // 暴力解法，遍历所有链表，然后放到List中，再排序，创建新的链表
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (ListNode list : lists) {
            ListNode cur = list;
            while (cur != null) {
                nums.add(cur.val);
                cur = cur.next;
            }
        }
        return rebuild(nums);
    }

    private ListNode rebuild(List<Integer> list) {
        list.sort((o1, o2) -> o1 - o2);
        ListNode head = new ListNode();
        ListNode cur = head;
        for (Integer integer : list) {
            cur.next = new ListNode(integer);
            cur = cur.next;
        }
        return head.next;
    }

    // 有个idx[] = new int[k] 表示k个list当前遍历到哪里了
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 1) return lists[0];
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i < lists.length; i++) {
            cur.next = merge(cur.next, lists[i]);
        }
        return cur.next;
    }

    // 合并2个链表
    private ListNode merge(ListNode n1, ListNode n2) {
        if (n2 == null) return n1;
        ListNode head = new ListNode();
        ListNode cur = head;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                cur.next = n1;
                n1 = n1.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;
        }
        while (n1 != null) {
            cur.next = n1;
            n1 = n1.next;
            cur = cur.next;
        }
        while (n2 != null) {
            cur.next = n2;
            n2 = n2.next;
            cur = cur.next;
        }
        return head.next;
    }
}
