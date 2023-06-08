package medium;

import support.Kiligz;
import type.DataStructure;

/**
 * 旋转图像
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * @author Ivan
 * @since 2023/5/6
 */
public class N0048 implements DataStructure.Matrix {
    public static void main(String[] args) {
        int[][] matrix = Kiligz.toMatrixIntArray(
                "1,2,3",
                "4,5,6",
                "7,8,9");
        new N0048().rotate(matrix);
        Kiligz.print(matrix);
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int r = 0; r < n / 2; r++) {
            for (int c = 0; c < n; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[n - 1 - r][c];
                matrix[n - 1 - r][c] = temp;
            }
        }
        // 对角线翻转
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < r; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }
}
