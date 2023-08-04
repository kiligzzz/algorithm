package easy;

import support.Kiligz;
import type.PrefixSum;

/**
 * 左右两边子数组的和相等
 * 输入：nums = [1,7,3,6,5,6]
 * 输出：3
 *
 * @author Ivan
 * @since 2023/8/1
 */
public class LCR012 implements PrefixSum {
    public static void main(String[] args) {
        int[] nums = Kiligz.toIntArray("1,7,3,6,5,6");
        Kiligz.print(new LCR012().pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (preSum * 2 + nums[i] == sum) return i;
            preSum += nums[i];
        }
        return -1;
    }
}
