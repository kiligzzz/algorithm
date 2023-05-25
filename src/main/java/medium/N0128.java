package medium;

import support.Kiligz;
import type.Common;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 *
 * @author Ivan
 * @since 2023/5/24
 */
public class N0128 implements Common.Number {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("100,4,200,1,3,2");
        Kiligz.print(new N0128().longestConsecutive(arr));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 0;
                while (set.contains(num)) {
                    num++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
