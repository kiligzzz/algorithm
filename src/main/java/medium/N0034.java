package medium;

import support.Kiligz;
import type.DataStructure;
import type.TwoPointer;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 *
 * @author Ivan
 * @since 2023/4/20
 */
public class N0034 implements DataStructure.Arrayed, TwoPointer.Binary {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("5,7,7,8,8,10");
        Kiligz.print(new N0034().searchRange(arr, 8));
    }

    public int[] searchRange(int[] nums, int target) {
        int l = binarySearchLeft(nums, target);
        int r = binarySearchLeft(nums, target + 1) - 1;
        if (l <= r && l >= 0 && r <= nums.length - 1) {
            return new int[]{l, r};
        }
        return new int[]{-1, -1};
    }

    /**
     * 给出>=target的最左边的索引
     */
    public int binarySearchLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            // 等于时也继续往左边看
            if (target <= nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
