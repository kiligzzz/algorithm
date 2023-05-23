package easy;

import support.Kiligz;
import type.DynamicProgramming;
import type.TwoPointer;

/**
 * 爬楼梯，每次爬1|2个楼梯
 * 输入：n = 2 输出：2
 *
 * @author Ivan
 * @since 2023/5/12
 */
public class N0070 implements DynamicProgramming, TwoPointer.SlideWindow {
    public static void main(String[] args) {
        Kiligz.print(new N0070().climbStairs(2));
    }

    /**
     * 勉强算是滑动窗口
     */
    public int climbStairs(int n) {
        int i, j = 0;
        int res = 1;
        for (int idx = 1; idx <= n; idx++) {
            i = j;
            j = res;
            res = i + j;
        }
        return res;
    }

    public int climbStairs1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
