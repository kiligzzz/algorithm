package easy;

import support.Kiligz;
import type.Common;

import java.util.HashSet;
import java.util.Set;

/**
 * 使数组中所有元素都等于0的次数
 *
 * @author Ivan
 * @since 2023/2/24
 */
public class N2357 implements Common.Hash {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("1,5,0,3,5");
        Kiligz.print(new N2357().minimumOperations(arr));
    }

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }
}
