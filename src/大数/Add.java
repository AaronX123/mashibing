package 大数;

import java.util.Scanner;

public class Add {
    public static String add(String num1, String num2) {
        if (num1 == null) return num2;
        if (num2 == null) return num1;

        char[] c1 = reverse(num1.toCharArray());
        char[] c2 = reverse(num2.toCharArray());
        StringBuilder sb = new StringBuilder();
        // 倒着来
        int carry = 0;
        for (int i = 0; i < c1.length || i < c2.length; i++) {
            if (i < c1.length) carry += c1[i] - '0';
            if (i < c2.length) carry += c2[i] - '0';
            sb.append(carry % 10);
            carry /= 10;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }

    private static char[] reverse(char[] chars) {
        char[] res = new char[chars.length];
        for (int i = chars.length - 1, j = 0; i >= 0; i--, j++) {
            res[j] = chars[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        add(scanner.nextLine(), scanner.nextLine());
    }
}
