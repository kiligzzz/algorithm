package medium;

import support.Kiligz;
import type.DataStructure;

/**
 * 有效的数独
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * 输出：true
 *
 * @author Ivan
 * @since 2023/4/20
 */
public class N0036 implements DataStructure.Arrayed {
    public static void main(String[] args) {
        char[][] board = Kiligz.to2DCharArray(
                "5,3,.,.,7,.,.,.,.",
                "6,.,.,1,9,5,.,.,.",
                ".,9,8,.,.,.,.,6,.",
                "8,.,.,.,6,.,.,.,3",
                "4,.,.,8,.,3,.,.,1",
                "7,.,.,.,2,.,.,.,6",
                ".,6,.,.,.,.,2,8,.",
                ".,.,.,4,1,9,.,.,5",
                ".,.,.,.,8,.,.,7,9"
        );
        Kiligz.print(new N0036().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        int[][] rows = new int[length][length];
        int[][] cols = new int[length][length];
        int[][] sudoku = new int[length][length];
        for (int r = 0; r < length; r++) {
            for (int c = 0; c < length; c++) {
                char num = board[r][c];
                if (num == '.') continue;

                // 该数分别在行、列、9宫格中的索引位置
                int idx = num - '0' - 1;
                // r / 3 * 3：一列可以放三个数独，每行有三个数独
                // c / 3：一行可以放三个数独
                int sudokuIdx = r / 3 * 3 + c / 3;
                if (rows[r][idx] == 1 || cols[c][idx] == 1 || sudoku[sudokuIdx][idx] == 1) {
                    return false;
                }
                rows[r][idx] = cols[c][idx] = sudoku[sudokuIdx][idx] = 1;
            }
        }
        return true;
    }
}
