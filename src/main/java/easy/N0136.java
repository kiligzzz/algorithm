package easy;

import support.Kiligz;
import type.Common;

/**
 * 只出现一次的数字
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * 异或操作：两个位相同为0，相异为1，一组数据中筛选唯一的奇数个元素
 *
 * @author Ivan
 * @since 2023/5/25
 */
public class N0136 implements Common.Number {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("4,1,2,1,2");
        Kiligz.print(new N0136().singleNumber(arr));
    }

    public int singleNumber(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n ^= num;
        }
        return n;
    }
}
