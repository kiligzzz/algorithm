package medium;

import support.Kiligz;
import type.Common;
import type.DynamicProgramming;
import type.Sort;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * @author Ivan
 * @since 2023/6/19
 */
public class Offer45 implements Common.Str, Sort, DynamicProgramming.Greed {
    public static void main(String[] args) {
        int[] nums = Kiligz.toIntArray("3,30,34,5,9");
        Kiligz.print(new Offer45().minNumber(nums));
    }

    /**
     * x + y < y + x ，则 x < y
     *  303  <  330   则 30 < 3
     */
    public String minNumber(int[] nums) {
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ss[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(ss, (a, b) -> (a + b).compareTo(b + a));
        return String.join("", ss);
    }
}
