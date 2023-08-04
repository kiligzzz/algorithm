package medium;

import support.Kiligz;
import type.Common;

/**
 * 只出现一次的数字
 * 输入：nums = [2,2,3,2]
 * 输出：3
 *
 * @author Ivan
 * @since 2023/7/7
 */
public class LCR004 implements Common.Number {
    public static void main(String[] args) {
        int[] nums = Kiligz.toIntArray("2,2,3,2");
        Kiligz.print(new LCR004().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int[] counter = new int[32];
        for (int num : nums) {
            for (int i = counter.length - 1; i >= 0; i--) {
                counter[i] += num & 1;
                num >>= 1;
            }
        }
        int res = 0;
        for (int count : counter) {
            res <<= 1;
            res |= count % 3;
        }
        return res;
    }
}
