package medium;

import support.Kiligz;
import type.DataStructure;
import type.PrefixSum;

/**
 * 二维子矩阵的和
 * 输入：[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]]    2,1,4,3
 * 输出：8
 *
 * @author Ivan
 * @since 2023/8/1
 */
public class LCR013 implements DataStructure.Matrix, PrefixSum {
    public static void main(String[] args) {
        int[][] matrix = Kiligz.toMatrixIntArray(
                "3,0,1,4,2",
                "5,6,3,2,1",
                "1,2,0,1,5",
                "4,1,0,1,7",
                "1,0,3,0,5");
        NumMatrix numMatrix = new NumMatrix(matrix);
        Kiligz.print(numMatrix.sumRegion(2,1,4,3));
    }


    static class NumMatrix {
        int[][] matrixSum;

        public NumMatrix(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            matrixSum = new int[row + 1][col + 1];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrixSum[i + 1][j + 1] = matrixSum[i][j + 1]
                            + matrixSum[i + 1][j]
                            - matrixSum[i][j]
                            + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            sum += matrixSum[row2 + 1][col2 + 1]
                    - matrixSum[row1][col2 + 1]
                    - matrixSum[row2 + 1][col1]
                    + matrixSum[row1][col1];
            return sum;
        }
    }
}
