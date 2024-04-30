package easy;

import support.Kiligz;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长和谐子序列
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 *
 * @author Ivan
 * @since 2024/4/15
 */
public class N0594 {
    public static void main(String[] args) {
        int[] nums = Kiligz.toIntArray("1,3,2,2,5,2,3,7");
        Kiligz.print(new N0594().findLHS(nums));
    }

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }

        int max = 0;
        for (Integer num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                max = Math.max(max, map.get(num) + map.get(num + 1));
            }
        }
        return max;
    }
}
