package easy;

import support.Kiligz;
import type.TwoPointer;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 *
 * @author Ivan
 * @since 2023/6/2
 */
public class Offer21 implements TwoPointer {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("1,2,3,4");
        Kiligz.print(new Offer21().exchange(arr));
    }

    public int[] exchange(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[r--] = num;
            } else {
                res[l++] = num;
            }
        }
        return res;
    }

    /**
     * 原地，结果不计入内存消耗的话，不如上面的好
     */
    public int[] exchange1(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            while (l < r && nums[l] % 2 != 0)
                l++;
            while (l < r && nums[r] % 2 == 0)
                r--;
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
        return nums;
    }
}
