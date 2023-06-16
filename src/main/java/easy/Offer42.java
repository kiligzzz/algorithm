package easy;

import support.Kiligz;
import type.DynamicProgramming;

/**
 * 连续子数组的最大和
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 *
 * @author Ivan
 * @since 2023/6/16
 */
public class Offer42 implements DynamicProgramming.Kadane {
    public static void main(String[] args) {
        int[] nums = Kiligz.toIntArray("-2,1,-3,4,-1,2,1,-5,4");
        Kiligz.print(new Offer42().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int pre = 0;
        int res = nums[0];
        for (int num : nums) {
            pre = num + Math.max(pre, 0);
            res = Math.max(pre, res);
        }
        return res;
    }
}
