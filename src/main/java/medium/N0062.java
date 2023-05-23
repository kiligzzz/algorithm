package medium;

import support.Kiligz;
import type.DynamicProgramming;

import java.util.Arrays;

/**
 * 不同路径
 * 输入：m = 3, n = 7
 * 输出：28
 *
 * @author Ivan
 * @since 2023/5/11
 */
public class N0062 implements DynamicProgramming {
    public static void main(String[] args) {
        Kiligz.print(new N0062().uniquePaths(3, 7));
    }

    /**
     * 动态规划（更好）
     */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        // 填充第一行全是1
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // dp[j]为上一行该位置记录的路径数（upper），dp[j - 1]，为左边记录的路径数（left）
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    /**
     * 动态规划
     */
    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];

        // 填充第一行和第一列都是1
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
