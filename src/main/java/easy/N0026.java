package easy;

import support.Kiligz;
import type.DataStructure;
import type.TwoPointer;

/**
 * 删除有序数组中的重复项
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 *
 * @author Ivan
 * @since 2023/4/17
 */
public class N0026 implements DataStructure.Arrayed, TwoPointer.FastSlowPointer {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("0,1,2,2,3");
        Kiligz.print(new N0026().removeDuplicates(arr));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[idx]) {
                if (i - idx++ > 1) {
                    nums[idx] = nums[i];
                }
            }
        }
        return idx + 1;
    }
}
