package medium;

import support.Kiligz;
import type.PrefixSum;
import type.TwoPointer;

/**
 * 乘积小于K的连续子数组个数
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 *
 * @author Ivan
 * @since 2023/7/13
 */
public class LCR009 implements TwoPointer.SlideWindow, PrefixSum {
    public static void main(String[] args) {
        int[] nums = Kiligz.toIntArray("10,5,2,6");
        Kiligz.print(new LCR009().numSubarrayProductLessThanK(nums, 100));
    }

    /**
     * l到r的子数组数量，如1到3 -> [6], [2,6], [5,2,6]
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int l = 0, r = 0;
        int prod = 1;
        while (r < nums.length) {
            prod *= nums[r];
            while (l <= r && prod >= k) {
                prod /= nums[l];
                l++;
            }
            res += r - l + 1;
            r++;
        }
        return res;
    }
}
