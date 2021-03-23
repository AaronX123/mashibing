package leetcode.middle;

import leetcode.ListNode;

import java.math.BigInteger;

public class no2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 将链表转成数字
        BigInteger a = castList(l1);
        BigInteger b = castList(l2);
        return castInt(a.add(b));
    }

    private static BigInteger castList(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        return new BigInteger(stringBuilder.reverse().toString());
    }

    private static ListNode castInt(BigInteger num) {
        String str = num + "";
        char[] chars = str.toCharArray();
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = chars.length - 1; i >= 0; i--) {
            cur.next = new ListNode(chars[i] - 48);
            cur = cur.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(4);
        ListNode l3 = new no2().addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}

