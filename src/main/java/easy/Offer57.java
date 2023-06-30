package easy;

import support.Kiligz;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的两个数字 & II
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 排序数组
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * 要求输出连续正整数序列，序列内的数字由小到大排列，不同序列按照首个数字从小到大排列
 *
 * @author Ivan
 * @since 2023/6/29
 */
public class Offer57 {
    public static void main(String[] args) {
//        int[] nums = Kiligz.toIntArray("2,7,11,15");
//        Kiligz.print(new Offer57().twoSum(nums, 9));

        Kiligz.print(new Offer57().findContinuousSequence(9));
    }

    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                return new int[]{nums[l], nums[r]};
            }
        }
        return new int[0];
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<int[]>();
        for (int l = 1, r = 2; l < r;) {
            // S = (首项 + 末项) * 项数 / 2
            int sum = (l + r) * (r - l + 1) / 2;
            if (sum > target) {
                l++;
            } else if (sum < target) {
                r++;
            } else {
                int[] arr = new int[r - l + 1];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = i + l;
                }
                res.add(arr);
                l++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
