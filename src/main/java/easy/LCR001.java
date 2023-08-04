package easy;

import support.Kiligz;
import type.Common;

/**
 * 整数除法
 * 输入：a = 15, b = 2
 * 输出：7
 * 要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 *
 * @author Ivan
 * @since 2023/7/6
 */
public class LCR001 implements Common.Number {
    public static void main(String[] args) {
        Kiligz.print(new LCR001().divide(15, 2));
    }

    /**
     * 减数倍增法
     * 转为负数处理，避免溢出（MIN_VALUE转正数会溢出）
     */
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;

        boolean flag = a > 0 && b > 0 || a < 0 && b < 0;
        if (a > 0) a = -a;
        if (b > 0) b = -b;

        int res = 0;
        while (a <= b) {
            int n = 1;
            int t = b;
            while (t >= Integer.MIN_VALUE / 2 && a <= t + t) {
                n += n;
                t += t;
            }
            a -= t;
            res += n;
        }
        return flag ? res : -res;
    }
}
