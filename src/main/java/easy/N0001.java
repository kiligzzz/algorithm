package easy;

import support.Kiligz;
import type.Common;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 输入：nums = [2,7,11,15], target = 9 输出：[0,1]
 *
 * @author Ivan
 * @since 2023/2/27
 */
public class N0001 implements Common.Hash {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("2,7,11,15");
        Kiligz.print(new N0001().twoSum(arr, 9));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(target - nums[i]);
            if (idx != null) {
                return new int[]{idx, i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
