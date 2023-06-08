package medium;

import support.Kiligz;
import type.DynamicProgramming;

/**
 * 最小路径和
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 *
 * @author Ivan
 * @since 2023/5/12
 */
public class N0064 implements DynamicProgramming {
    public static void main(String[] args) {
        int[][] arr = Kiligz.toMatrixIntArray(
                "1,3,1",
                "1,5,1",
                "4,2,1");
        Kiligz.print(new N0064().minPathSum(arr));
    }

    public int minPathSum(int[][] grid) {
        int n = grid[0].length;
        int[] dp = new int[n];

        for (int[] arr : grid) {
            // 换行设置每行第一位
            dp[0] = dp[0] + arr[0];

            for (int j = 1; j < n; j++) {
                // 若是第一行，则只看左边的
                int min = arr == grid[0] ?
                        dp[j - 1] : Math.min(dp[j], dp[j - 1]);
                dp[j] = arr[j] + min;
            }
        }
        return dp[n - 1];
    }

    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                int upper = i == 0 ? Integer.MAX_VALUE : dp[i - 1][j];
                int left = j == 0 ? Integer.MAX_VALUE : dp[i][j - 1];
                dp[i][j] = grid[i][j] + Math.min(upper, left);
            }
        }

        return dp[m - 1][n - 1];
    }
}
