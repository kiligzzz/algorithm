package medium;

import support.Kiligz;
import type.CSF;
import type.DFS;
import type.Recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列II
 * 有重不可复用，不能有重复结果
 * 输入：nums = [1,1,2]
 * 输出：[[1,1,2],[1,2,1],[2,1,1]]
 *
 * @author Ivan
 * @since 2023/4/25
 */
public class N0047 implements CSF.FullPermutation, DFS.Backtrack, Recursive {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("1,1,2");
        Kiligz.print(new N0047().permuteUnique(arr));
    }
    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();

    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    public void backtrack(int[] nums) {
        if (list.size() == nums.length)
            res.add(new ArrayList<>(list));

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            // 保证i位置的元素一定在i-1位置相同元素之前（该方法会比hash效率高些）
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;

            used[i] = true;
            list.addLast(nums[i]);
            backtrack(nums);
            list.removeLast();
            used[i] = false;
        }
    }
}
