package medium;

import support.Kiligz;
import type.PrefixSum;
import type.TwoPointer;

/**
 * 和大于等于target的最短连续子数组
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 *
 * @author Ivan
 * @since 2023/7/12
 */
public class LCR008 implements TwoPointer.SlideWindow, PrefixSum {
    public static void main(String[] args) {
        int[] nums = Kiligz.toIntArray("2,3,1,2,4,3");
        Kiligz.print(new LCR008().minSubArrayLen(7, nums));
    }

    /**
     * @Attention：数据中没有负数，才能用滑动窗口（左指针右移和右指针右移，需保证效果相反）
     */
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (l <= r && sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
