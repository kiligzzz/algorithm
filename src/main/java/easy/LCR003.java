package easy;

import support.Kiligz;
import type.Common;

/**
 * 前n个数字二进制中1的个数
 * 输入: n = 2
 * 输出: [0,1,1]
 *
 * @author Ivan
 * @since 2023/7/6
 */
public class LCR003 implements Common.Number {
    public static void main(String[] args) {
        Kiligz.print(new LCR003().countBits(2));
    }

    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = count(i);
        }
        return res;
    }

    private int count(int x) {
        int count = 0;
        while (x > 0) {
            // 将x的二进制表示的最后一个1变成0
            x &= x - 1;
            count++;
        }
        return count;
    }
}
