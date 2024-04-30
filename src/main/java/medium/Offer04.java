package medium;

import support.Kiligz;
import type.Binary;
import type.TwoPointer;

/**
 * 二维数组的查找
 *
 * @author Ivan
 * @since 2023/4/3
 */
public class Offer04 implements TwoPointer, Binary {
    public static void main(String[] args) {
        int[][] matrix = Kiligz.toMatrixIntArray(
                "1,4,7,11,15",
                "2,5,8,12,19",
                "3,6,9,16,22",
                "10,13,14,17,24",
                "18,21,23,26,30"
        );
        Kiligz.print(new Offer04().findNumberIn2DArray(matrix, 99));
    }

    /**
     * 就是一个斜向的二叉查找树，15是根节点
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int i = 0;
        int j = matrix[0].length - 1;
        while (i <= matrix.length - 1 && j >= 0) {
            if (matrix[i][j] == target)
                return true;

            if (matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }
}
