package medium;

import support.Kiligz;
import type.Common;
import type.PrefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为k的连续子数组
 * 输入:nums = [1,2,3,4,5,4,3,2,1], k = 9
 * 输出: 4
 *
 * @author Ivan
 * @since 2023/7/21
 */
public class OfferII010 implements Common.Hash, PrefixSum {
    public static void main(String[] args) {
        int[] nums = Kiligz.toIntArray("1,2,3,4,5,4,3,2,1");
        Kiligz.print(new OfferII010().subarraySum(nums, 9));
    }

    /**
     * map的key(当前位置前缀和),value(当前位置前缀和 - k 的出现次数)
     * 当前位置前缀和-k存在：前一个前缀和位置 到 当前位置 一定有连续的几个数字相加等于k
     */
    public int subarraySum(int[] nums, int k) {
        int res = 0, preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            preSum += num;
            Integer preCount = map.get(preSum - k);
            if (preCount != null) {
                res += preCount;
            }
            map.merge(preSum, 1, (old, fresh) -> old + 1);
        }
        return res;
    }
}
