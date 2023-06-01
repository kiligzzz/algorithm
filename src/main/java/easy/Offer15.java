package easy;

import support.Kiligz;
import type.Common;

/**
 * 二进制中1的个数
 * 输入：n = 11 (控制台输入 00000000000000000000000000001011)
 * 输出：3
 *
 * @author Ivan
 * @since 2023/5/31
 */
public class Offer15 implements Common.Number {
    public static void main(String[] args) {
        Kiligz.print(new Offer15().hammingWeight(11));
    }

    public int hammingWeight(int n) {
        int ret = 0;
        // 每位都和1进行&运算，都为1时才是1，可得出1的个数
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }
}
