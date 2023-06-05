package easy;

import support.Kiligz;
import type.Common;

/**
 * 打印从1到最大的n位数
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * @author Ivan
 * @since 2023/6/1
 */
public class Offer17 implements Common.Number {
    public static void main(String[] args) {
        Kiligz.print(new Offer17().printNumbers(3));
    }

    public int[] printNumbers(int n) {
        int[] res = new int[(int) Math.pow(10, n) - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
