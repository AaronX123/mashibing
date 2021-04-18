package leetcode.middle;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class no148 {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        Integer[] integers = list.toArray(new Integer[list.size()]);
        Arrays.sort(integers);
        head = new ListNode(integers[0]);
        cur = head;
        for (int i = 1; i < integers.length; i++) {
            cur.next = new ListNode(integers[i]);
            cur = cur.next;
        }
        return head;
    }
}
