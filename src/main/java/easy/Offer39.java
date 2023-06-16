package easy;

import support.Kiligz;
import type.Common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现次数超过一半的数字
 * 输入: [1,2,3,2,2,2,5,4,2]
 * 输出: 2
 *
 * @author Ivan
 * @since 2023/6/16
 */
public class Offer39 implements Common.Hash {
    public static void main(String[] args) {
        int[] nums = Kiligz.toIntArray("8,8,7,7,7");
        Kiligz.print(new Offer39().majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int res = -1;
        for (int num : nums) {
            int cur = map.merge(num, 1, (old, fresh) -> old + 1);
            if (cur > max) {
                max = cur;
                res = num;
            }
        }
        return res;
    }
}
