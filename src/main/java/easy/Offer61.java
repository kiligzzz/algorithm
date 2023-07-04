package easy;

import support.Kiligz;
import type.Common;

import java.util.HashSet;
import java.util.Set;

/**
 * 扑克牌中的顺子
 * 输入: [0,0,1,2,5]
 * 输出: true
 * 0可以为任意数字
 *
 * @author Ivan
 * @since 2023/7/3
 */
public class Offer61 implements Common.Hash {
    public static void main(String[] args) {
        int[] nums = Kiligz.toIntArray("1,2,3,4,5");
        Kiligz.print(new Offer61().isStraight(nums));
    }

    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 13;
        for (int num : nums) {
            if (num == 0) continue;
            if (!set.add(num)) return false;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return max - min < 5;
    }
}
