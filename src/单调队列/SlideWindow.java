package 单调队列;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SlideWindow {
    private static int N = 100010;
    public static void slideWindow(int k, int[] arr) {
        int[] res = new int[arr.length - k + 1];
        // 记录下标
        int[] queue = new int[N];
        int head = 0, tail = -1;
        for (int i = 0; i < arr.length; i++) {
            // 如果超过了窗口范围
            if (head <= tail && i - k + 1 > queue[head]) head++;
            // 如果新的数字比窗口里的数字小，则去把窗口里数字剔除
            while (head <= tail && arr[queue[tail]] >= arr[i]) tail--;
            queue[++tail] = i;
            if (i >= k - 1) res[i - k + 1] = arr[queue[head]];
        }
        printArray(res);
        head = 0; tail = -1;
        for (int i = 0; i < arr.length; i++) {
            if (head <= tail && i - k + 1 > queue[head]) head++;
            while (head <= tail && arr[queue[tail]] <= arr[i]) tail--;
            queue[++tail] = i;
            if (i > k) res[i - k] = queue[head];
        }
        printArray(res);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String nk = bufferedReader.readLine();
        String str = bufferedReader.readLine();
        int k = Integer.parseInt(nk.split(" ")[1]);
        String[] strs = str.split(" ");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        slideWindow(k, arr);
    }
}
