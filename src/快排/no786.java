package 快排;

public class no786 {
    public static void main(String[] args) {

    }

    public static int getK(int[] arr, int k, int l, int r) {
        if (l >= r) return arr[l];
        int p = arr[l];
        int i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (p > arr[i]);
            do j--; while (p < arr[j]);
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 如果左边的个数小于K个，那么一定在右边
        int sl = j - l + 1;
        if (sl >= k) return getK(arr, l, j, k);
        return getK(arr, j + 1, r, k - sl);
    }

}
