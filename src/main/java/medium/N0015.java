package medium;

import support.Kiligz;
import type.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 输入：nums = [-1,0,1,2,-1,-4] 输出：[[-1,-1,2],[-1,0,1]]
 *
 * @author Ivan
 * @since 2023/3/1
 */
public class N0015 implements TwoPointer {

    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("-1,0,1,2,-1,-4");
        Kiligz.print(new N0015().threeSum(arr));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            // 去重，否则就有多个从i开始的了
            if (i >= 1 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            int sum;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重，否则就有多个相同left/right的了
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
                else if (sum < 0) left++;
                else right--;
            }
        }
        return res;
    }
}
