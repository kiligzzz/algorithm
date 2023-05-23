package easy;

import support.Kiligz;
import type.DataStructure;

import java.util.Arrays;

/**
 * 数组中重复的数字
 * 输入：[2,3,1,0,2,5,3] 输出：2 或 3
 *
 * @author Ivan
 * @since 2023/3/1
 */
public class Offer03 implements DataStructure.Arrayed {

    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("2,3,1,0,2,5,3");
        Kiligz.print(new Offer03().findRepeatNumber2(arr));
    }

    /**
     * 执行耗时:3 ms,击败了61.71% 的Java用户
     * 内存消耗:48.7 MB,击败了79.34% 的Java用户
     */
    public int findRepeatNumber1(int[] nums) {
        Arrays.sort(nums);
        int last = -1;
        for (int num : nums) {
            if (last == num) {
                return num;
            }
            last = num;
        }
        return 0;
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:48.4 MB,击败了98.89% 的Java用户
     * 0到n-1，若没有重复，每个都可放在对应索引位置上
     */
    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int num = nums[i];
            if (num == i) {
                i++;
                continue;
            }
            if (nums[num] == num)
                return num;

            nums[i] = nums[num];
            nums[num] = num;
        }
        return -1;
    }



}
