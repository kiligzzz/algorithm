package medium;

import support.Kiligz;
import type.DynamicProgramming;

/**
 * 剪绳子I & II
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * @author Ivan
 * @since 2023/5/30
 */
public class Offer14 implements DynamicProgramming.Greed {
    public static void main(String[] args) {
        Kiligz.print(new Offer14().cuttingRope2(120));
    }

    static final int MOD = 1000000007;

    public int cuttingRope1(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int res = 1;
        while (n > 4) {
            // 3是最小的因子，因子越多乘积越大
            n -= 3;
            res = res * 3;
        }
        return res * n;
    }

    public int cuttingRope2(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        long res = 1;
        while (n > 4) {
            n -= 3;
            res = res * 3 % MOD;
        }
        return (int) (res * n % MOD);
    }
}
