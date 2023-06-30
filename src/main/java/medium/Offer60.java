package medium;

import support.Kiligz;
import type.DynamicProgramming;

import java.util.Arrays;

/**
 * n个骰子的点数
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *
 * @author Ivan
 * @since 2023/6/30
 */
public class Offer60 implements DynamicProgramming {
    public static void main(String[] args) {
        Kiligz.print(new Offer60().dicesProbability(2));
    }

    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] nextDp = new double[i * 5 + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    nextDp[j + k] += dp[j] / 6.0;
                }
            }
            dp = nextDp;
        }
        return dp;
    }
}
