package medium;

import support.Kiligz;
import type.CSF;
import type.DFS;
import type.Recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * 无重不可复用，不能有重复结果
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * @author Ivan
 * @since 2023/4/25
 */
public class N0078 implements CSF.Subset, DFS.Backtrack, Recursive {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("1,2,3");
        Kiligz.print(new N0078().subsets(arr));
    }

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.addLast(nums[i]);
            backtrack(nums, i + 1);
            list.removeLast();
        }
    }
}
