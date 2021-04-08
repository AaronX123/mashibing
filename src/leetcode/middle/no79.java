package leetcode.middle;

public class no79 {

    boolean[][] used = new boolean[100][100];
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist0(board, i, j, word.length() - 1, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist0(char[][] board, int i, int j, int remainLength, String word) {
        if (remainLength == -1) {
            return true;
        }
        if (i > - 1 && i < board.length && j > -1 && j < board[0].length && board[i][j] == word.charAt(word.length() - remainLength - 1)) {
            if (used[i][j]) return false;
            used[i][j] = true;
            boolean flag = false;
            flag |= exist0(board, i, j + 1, remainLength - 1, word);
            flag |= exist0(board, i + 1, j, remainLength - 1, word);
            flag |= exist0(board, i - 1, j, remainLength - 1, word);
            flag |= exist0(board, i, j - 1, remainLength - 1, word);
            used[i][j] = false;
            return flag;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        new no79().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB");
    }
}
