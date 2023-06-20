package medium;

import support.Kiligz;
import type.Common;

/**
 * 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中，求任意第n位对应的数字
 * 输入：n = 3
 * 输出：3
 *
 * @author Ivan
 * @since 2023/6/19
 */
public class Offer44 implements Common.Number {
    public static void main(String[] args) {
        Kiligz.print(new Offer44().findNthDigit(1000));
    }

    public int findNthDigit(int n) {
        // 数字位数
        int digit = 1;
        // 开始位置
        long start = 1;
        // 该数字位数下字符串的位数
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // n位置所在的数字
        long num = start + (n - 1) / digit;
        // n位置在num中的相对位置
        int idx = (n - 1) % digit;
        return Long.toString(num).charAt(idx) - '0';
    }
}
