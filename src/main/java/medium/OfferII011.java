package medium;

import support.Kiligz;
import type.PrefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 0和1个数相同的子数组最大长度
 * 输入: nums = [0,1,0] 输出: 2
 *
 * @author Ivan
 * @since 2023/7/24
 */
public class OfferII011 implements PrefixSum {
    public static void main(String[] args) {
        int[] nums = Kiligz.toIntArray("0,1,0");
        Kiligz.print(new OfferII011().findMaxLength(nums));
    }

    /**
     * map的key(当前位置前缀和),value(当前位置)
     */
    public int findMaxLength(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        map.put(preSum, -1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(preSum)) {
                // 前缀和为该值的最左索引
                int preIdx = map.get(preSum);
                res = Math.max(res, i - preIdx);
            } else {
                map.put(preSum, i);
            }
        }
        return res;
    }

}
