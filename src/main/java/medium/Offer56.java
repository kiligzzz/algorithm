package medium;

import support.Kiligz;
import type.Common;

/**
 * 数组中数字出现的次数I & II
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 两个数字都出现一次，其他数字都出现两次
 *
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * 一个数字只出现一次，其他数字都出现三次
 *
 * @author Ivan
 * @since 2023/6/28
 */
public class Offer56 implements Common.Number {
    public static void main(String[] args) {
//        int[] nums = Kiligz.toIntArray("4,1,4,6");
//        Kiligz.print(new Offer56().singleNumbers(nums));

        int[] nums = Kiligz.toIntArray("1,1,6,1");
        Kiligz.print(new Offer56().singleNumber(nums));
    }

    /**
     * 两个只出现一次数字，记作A、B
     * 异或：相同为0，相异为1
     */
    public int[] singleNumbers(int[] nums) {
        // 得出A、B的异或结果
        int xor = 0;
        for (int num : nums)
            xor ^= num;

        // 找到xor中为1（相异）的最低位（此时A & div != B & div，用于将A、B分到不同的组）
        int div = 1;
        while ((div & xor) == 0)
            div <<= 1;

        int a = 0, b = 0;
        for (int num : nums) {
            if ((div & num) == 0)
                a ^= num;
            else
                b ^= num;
        }
        return new int[]{a, b};
    }

    /**
     * 对二进制各个位值上的1计数，对3取模后的剩下的数字即为只出现1次的数字
     */
    public int singleNumber(int[] nums) {
        // 倒序记录二进制各个位置上的1的个数
        int[] counter = new int[32];
        for (int num : nums) {
            for (int i = counter.length - 1; i >= 0; i--) {
                counter[i] += num & 1;
                num >>= 1;
            }
        }
        // 对3取模后转为十进制即为剩下的数字
        int res = 0;
        for (int count : counter) {
            res <<= 1;
            res |= count % 3;
        }
        return res;
    }
}
