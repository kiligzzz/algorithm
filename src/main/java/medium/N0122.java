package medium;

import support.Kiligz;
import type.DynamicProgramming;

/**
 * 买卖股票的最佳时机II
 * 可买卖多次
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 *
 * @author Ivan
 * @since 2023/5/24
 */
public class N0122 implements DynamicProgramming.Greed {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("7,1,5,3,6,4");
        Kiligz.print(new N0122().maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max += Math.max(0, prices[i] - prices[i - 1]);
        }
        return max;
    }
}
