package 二分;

public class CubeRoot {
    public static double cubeRoot(double n, double l, double r) {
        boolean negative = n < 0;
        n = Math.abs(n);
        while (r - l > 1e-8) {
            double mid = (l + r) / 2;
            if (mid * mid * mid >= n) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return negative ? -l : l;
    }

    public static void main(String[] args) {
        System.out.printf("%.6f",CubeRoot.cubeRoot(100, -10000, 10000));
    }
}
