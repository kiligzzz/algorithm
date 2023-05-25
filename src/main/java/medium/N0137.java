package medium;

import support.Kiligz;
import type.Common;
import type.FSM;

/**
 * 只出现一次的数字II
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *
 * @author Ivan
 * @since 2023/5/25
 */
public class N0137 implements Common.Number, FSM {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("0,1,0,1,0,1,99");
        Kiligz.print(new N0137().singleNumber(arr));
    }

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
