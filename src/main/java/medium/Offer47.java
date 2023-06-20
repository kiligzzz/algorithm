package medium;

import support.Kiligz;
import type.DataStructure;
import type.DynamicProgramming;

/**
 * 礼物的最大价值
 * 输入: [[1,3,1],[1,5,1],[4,2,1]]
 * 输出: 12
 *
 * @author Ivan
 * @since 2023/6/20
 */
public class Offer47 implements DataStructure.Matrix, DynamicProgramming {
    public static void main(String[] args) {
        int[][] grid = Kiligz.toMatrixIntArray(
                "1,3,1",
                "1,5,1",
                "4,2,1");
        Kiligz.print(new Offer47().maxValue(grid));
    }

    public int maxValue(int[][] grid) {
        int n = grid[0].length;
        int[] dp = new int[n];
        for (int[] nums : grid) {
            for (int j = 0; j < n; j++) {
                int max = j == 0 ? dp[j] : Math.max(dp[j], dp[j - 1]);
                dp[j] = max + nums[j];
            }
        }
        return dp[n - 1];
    }

    public int maxValue1(int[][] grid) {
        int rl = grid.length;
        int cl = grid[0].length;
        int[][] dp = new int[rl][cl];
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                dp[i][j] += grid[i][j];
            }
        }
        return dp[rl - 1][cl - 1];
    }
}
