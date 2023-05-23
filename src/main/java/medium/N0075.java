package medium;

import support.Kiligz;
import type.TwoPointer;

/**
 * 颜色分类
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * @author Ivan
 * @since 2023/5/12
 */
public class N0075 implements TwoPointer.FastSlowPointer {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("2,0,2,1,1,0");
        new N0075().sortColors(arr);
        Kiligz.print(arr);
    }

    public void sortColors(int[] nums) {
        // l位置之前的都已经放好
        int l = 0;
        for (int color = 0; color < 2; color++) {
            for (int r = l; r < nums.length; r++) {
                if (nums[r] == color) {
                    int temp = nums[r];
                    nums[r] = nums[l];
                    nums[l++] = temp;
                }
            }
        }
    }
}
