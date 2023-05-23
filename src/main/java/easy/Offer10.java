package easy;

import support.Kiligz;
import type.DynamicProgramming;

/**
 * 斐波那契数列 & 青蛙跳台阶
 * 5 -> 5       7 -> 21
 *
 * @author Ivan
 * @since 2023/4/10
 */
public class Offer10 implements DynamicProgramming {
    public static void main(String[] args) {
        Offer10 offer10 = new Offer10();
        Kiligz.print(offer10.fib(5));
//        Run.print(offer10.numWays(7));
    }
    public int fib(int n) {
        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    public int numWays(int n) {
        if (n == 0) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
