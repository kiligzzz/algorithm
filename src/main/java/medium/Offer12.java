package medium;

import support.Kiligz;
import type.DFS;
import type.DataStructure;
import type.Recursive;

/**
 * 矩阵中的路径
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],
 * word = "ABCCED" 输出：true
 * 要求：可从任意单元格出发，同一个单元格内的字母不允许被重复使用
 *
 * @author Ivan
 * @since 2023/5/30
 */
public class Offer12 implements DataStructure.Arrayed, DFS.Backtrack, Recursive {
    public static void main(String[] args) {
        char[][] chars = Kiligz.to2DCharArray(
                "A,B,C,E",
                "S,F,C,S",
                "A,D,E,E");
        Kiligz.print(new Offer12().exist(chars, "SEE"));
    }

    char[][] board;
    String word;
    int m;
    int n;
    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.m = board.length;
        this.n = board[0].length;
        this.used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean backtrack(int i, int j, int idx) {
        if (i < 0 || j < 0 || i == m || j == n
                || used[i][j]
                || word.charAt(idx) != board[i][j])
            return false;
        if (idx == word.length() - 1)
            return true;

        used[i][j] = true;
        boolean upper = backtrack(i - 1, j, idx + 1);
        boolean under = backtrack(i + 1, j, idx + 1);
        boolean left = backtrack(i, j - 1, idx + 1);
        boolean right = backtrack(i, j + 1, idx + 1);
        used[i][j] = false;
        return upper || under || left || right;
    }
}
