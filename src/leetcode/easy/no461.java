package leetcode.easy;

public class no461 {
    // 先异或，再求出二进制数中1的个数
    public int hammingDistance(int x, int y) {
        int a = x ^ y;
        return the1ofBinary(a);
    }

    // n & n -1 会把 n 的二进制中最后一个 1变成0，高位不变，因此只要不为零就可以一直操作
    private int the1ofBinary(long a) {
        int count = 0;
        while (a != 0) {
            a &= a - 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new no461().the1ofBinary(1111111101));
    }
}
