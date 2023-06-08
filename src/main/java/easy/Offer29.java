package easy;

import support.Kiligz;
import type.DataStructure;

/**
 * 顺时针打印矩阵
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * @author Ivan
 * @since 2023/6/7
 */
public class Offer29 implements DataStructure.Matrix {
    public static void main(String[] args) {
        int[][] matrix = Kiligz.toMatrixIntArray(
                "1,2,3",
                "4,5,6",
                "7,8,9");
        Kiligz.print(new Offer29().spiralOrder(matrix));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1;
        int t = 0, b = matrix.length - 1;
        int[] res = new int[(r + 1) * (b + 1)];
        int idx = 0;
        while (true) {
            // left to right
            for (int i = l; i <= r; i++) res[idx++] = matrix[t][i];
            if (++t > b) break;
            // top to bottom.
            for (int i = t; i <= b; i++) res[idx++] = matrix[i][r];
            if (l > --r) break;
            // right to left.
            for (int i = r; i >= l; i--) res[idx++] = matrix[b][i];
            if (t > --b) break;
            // bottom to top.
            for (int i = b; i >= t; i--) res[idx++] = matrix[i][l];
            if (++l > r) break;
        }
        return res;
    }
}
