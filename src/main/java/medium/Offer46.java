package medium;

import support.Kiligz;
import type.Common;
import type.DynamicProgramming;

/**
 * 把数字翻译成字符串
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * @author Ivan
 * @since 2023/6/20
 */
public class Offer46 implements Common.Number, DynamicProgramming {
    public static void main(String[] args) {
        Kiligz.print(new Offer46().translateNum(12258));
    }

    /**
     * x1x2...x(i-1)xi
     * x(i-1)xi整体翻译时：f(n-2)
     * xi单独翻译时：f(n-1)
     *
     * 能整体翻译时（10<= <=25）：f(n) = f(n - 1) + f(n - 2)
     * 不能整体翻译时：f(n) = f(n - 1)
     */
    public int translateNum(int num) {
        int fnm1 = 1;
        int fnm2 = 1;
        while(num != 0) {
            int r = num % 10;
            num /= 10;
            int l = num % 10;

            int tmp = 10 * l + r;
            int fn = (tmp >= 10 && tmp <= 25) ? fnm1 + fnm2 : fnm1;
            fnm2 = fnm1;
            fnm1 = fn;
        }
        return fnm1;
    }

}
