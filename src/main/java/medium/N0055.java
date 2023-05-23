package medium;

import support.Kiligz;
import type.DynamicProgramming;

/**
 * 跳跃游戏
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 *
 * @author Ivan
 * @since 2023/5/10
 */
public class N0055 implements DynamicProgramming.Greed {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("3,2,1,0,4");
        Kiligz.print(new N0055().canJump(arr));
    }

    public boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i <= rightMost; i++) {
            rightMost = Math.max(rightMost, i + nums[i]);
            if (rightMost >= nums.length - 1)
                return true;
        }
        return false;
    }
}
