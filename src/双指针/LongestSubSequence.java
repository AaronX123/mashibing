package 双指针;

import java.util.Scanner;

public class LongestSubSequence {
    public static int subSequence(int[] arr) {
        // 这里面装的是i对应的数值出现过的个数
        int[] s = new int[100010];
        int res = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            s[arr[i]]++;
            // 这里相当于把重复的元素位置前到j的中间所有数字剔除
            while (j < i && s[arr[i]] > 1) {
                s[arr[j]]--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(LongestSubSequence.subSequence(new int[]{1,2,2,3,5}));
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = scanner.nextLine();
        String[] strings = str.split(" ");
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(LongestSubSequence.subSequence(arr));
    }

}
