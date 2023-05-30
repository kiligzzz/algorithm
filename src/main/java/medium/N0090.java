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
 * 子集II
 * 有重不可复用，不能有重复结果
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * @author Ivan
 * @since 2023/4/25
 */
public class N0090 implements CSF.Subset, DFS.Backtrack, Recursive {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("1,2,2");
        Kiligz.print(new N0090().subsetsWithDup(arr));
    }

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;

            list.addLast(nums[i]);
            backtrack(nums, i + 1);
            list.removeLast();
        }
    }
}
