package medium;

import support.Kiligz;
import type.Common;

/**
 * 整数反转
 * 输入：x = 123 输出：321
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）
 *
 * @author Ivan
 * @since 2023/2/28
 */
public class N0007 implements Common.Number {

    public static void main(String[] args) {
        Kiligz.print(new N0007().reverse(123));
    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10
                    || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
