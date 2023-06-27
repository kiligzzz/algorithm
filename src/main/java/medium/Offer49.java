package medium;

import support.Kiligz;
import type.Common;
import type.DynamicProgramming;
import type.TwoPointer;

/**
 * 丑数
 * 输入: n = 10
 * 输出: 12
 * 只包含质因子 2、3 和 5 的数称作丑数
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数
 *
 * @author Ivan
 * @since 2023/6/25
 */
public class Offer49 implements Common.Number, DynamicProgramming, TwoPointer {
    public static void main(String[] args) {
        Kiligz.print(new Offer49().nthUglyNumber(10));
    }

    /**
     * 三个指针分别指向该质因子可得出的丑数，每次取三个中最小的，相同则指针同时右移
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
