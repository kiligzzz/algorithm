package medium;

import support.Kiligz;
import type.TwoPointer;

/**
 * 和大于等于target的最短子数组
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 *
 * @author Ivan
 * @since 2023/7/12
 */
public class OfferII008 implements TwoPointer.SlideWindow {
    public static void main(String[] args) {
        int[] nums = Kiligz.toIntArray("2,3,1,2,4,3");
        Kiligz.print(new OfferII008().minSubArrayLen(7, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
