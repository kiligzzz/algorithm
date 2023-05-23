package medium;

import support.Kiligz;
import type.DynamicProgramming;

/**
 * 最大子数组和
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 *
 * @author Ivan
 * @since 2023/5/6
 */
public class N0053 implements DynamicProgramming.Kadane {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("-2,1,-3,4,-1,2,1,-5,4");
        Kiligz.print(new N0053().maxSubArray(arr));
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
