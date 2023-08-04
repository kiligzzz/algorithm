package easy;

import support.Kiligz;
import type.TwoPointer;

/**
 * 排序数组中两个数字之和
 * 输入：numbers = [1,2,4,6,10], target = 8
 * 输出：[1,3]
 *
 * @author Ivan
 * @since 2023/7/10
 */
public class LCR006 implements TwoPointer {
    public static void main(String[] args) {
        int[] nums = Kiligz.toIntArray("2,3,4");
        Kiligz.print(new LCR006().twoSum(nums, 6));
    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum > target)
                r--;
            else if (sum < target)
                l++;
            else
                return new int[]{l, r};
        }
        return new int[0];
    }
}
