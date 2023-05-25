package easy;

import support.Kiligz;
import type.TwoPointer;

/**
 * 买卖股票的最佳时机
 * 只可买卖一次
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 *
 * @author Ivan
 * @since 2023/5/24
 */
public class N0121 implements TwoPointer {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("7,1,5,3,6,4");
        Kiligz.print(new N0121().maxProfit(arr));
    }

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (min > price) {
                min = price;
            } else {
                max = Math.max(max, price - min);
            }
        }
        return max;
    }
}
