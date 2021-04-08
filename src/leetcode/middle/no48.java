package leetcode.middle;

public class no48 {
    public void rotate(int[][] matrix) {
        // 四个方向
        int round = 0;
        // 向上取整，例如3x3就是2圈，4x4也是2圈
        int maxRound = matrix.length % 2 == 1 ? (matrix.length >> 1) + 1 : matrix.length >> 1;
        for (; round < maxRound; round++) {
            for (int i = round; i < matrix.length -1 - round; i++) {
                // -> 方向的值由 ↑ 的值替换
                int temp = matrix[round][i];
                matrix[round][i] = matrix[matrix.length - 1 - i][round];
                // ↑的值由 <-方向的值替换
                matrix[matrix.length - 1 - i][round] = matrix[matrix.length - 1 - round][matrix.length - 1 - i];
                // <-方向的值由 ↓ 的值替换
                matrix[matrix.length - 1 - round][matrix.length -1 - i] = matrix[i][matrix.length - 1 - round];
                // ↓ 的值由 -> 的值替换
                matrix[i][matrix.length - 1 - round] = temp;
            }
        }
    }

    public static void main(String[] args) {
        //new no48().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        new no48().rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
    }
}
