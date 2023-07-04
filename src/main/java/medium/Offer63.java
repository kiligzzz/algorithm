package medium;

import support.Kiligz;
import type.DynamicProgramming;

/**
 * 股票的最大利润
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 *
 * @author Ivan
 * @since 2023/7/3
 */
public class Offer63 implements DynamicProgramming {
    public static void main(String[] args) {
        int[] prices = Kiligz.toIntArray("7,1,5,3,6,4");
        Kiligz.print(new Offer63().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                res = Math.max(res, price - min);
            }
        }
        return res;
    }
}
