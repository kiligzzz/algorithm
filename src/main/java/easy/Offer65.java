package easy;

import support.Kiligz;
import type.Common;

/**
 * 不用加减乘除做加法
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * @author Ivan
 * @since 2023/7/4
 */
public class Offer65 implements Common.Number {
    public static void main(String[] args) {
        Kiligz.print(new Offer65().add(3, 4));
    }

    public int add(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
