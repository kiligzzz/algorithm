package medium;

import support.Kiligz;
import type.Binary;
import type.DataStructure;
import type.TwoPointer;

/**
 * 搜索旋转排序数组
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 * @author Ivan
 * @since 2023/4/19
 */
public class N0033 implements DataStructure.Arrayed, TwoPointer, Binary {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("3,1");
        Kiligz.print(new N0033().search(arr, 0));
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (target == nums[mid])
                return mid;

            // 解决 (0 + 1) / 2 = 0的问题，结果可能还在左边
            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[nums.length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
