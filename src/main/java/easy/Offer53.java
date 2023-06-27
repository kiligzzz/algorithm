package easy;

import support.Kiligz;
import type.Binary;
import type.DataStructure;
import type.TwoPointer;

/**
 * 在排序数组中查找数字 & 0~n-1中缺失的数字
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 输入: [0,1,3]
 * 输出: 2
 *
 * @author Ivan
 * @since 2023/6/27
 */
public class Offer53 implements DataStructure.Arrayed, TwoPointer, Binary {
    public static void main(String[] args) {
//        int[] nums = Kiligz.toIntArray("5,7,7,8,8,10");
//        Kiligz.print(new Offer53().search(nums, 8));

        int[] nums = Kiligz.toIntArray("0,1,3");
        Kiligz.print(new Offer53().missingNumber(nums));
    }

    /**
     * 在排序数组中查找数字
     */
    public int search(int[] nums, int target) {
        int l = binarySearchLeft(nums, target);
        int r = binarySearchLeft(nums, target + 1) - 1;
        return r - l + 1;
    }

    /**
     * 0~n-1中缺失的数字
     */
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) return i;
        }
        return nums.length;
    }

    private int binarySearchLeft(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
