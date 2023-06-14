package medium;

import support.Kiligz;
import type.CSF;
import type.DFS;
import type.Recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * 无重不可复用，不能有重复结果
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * @author Ivan
 * @since 2023/4/25
 */
public class N0046 implements CSF.FullPermutation, DFS.Backtrack, Recursive {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("1,2,3");
        Kiligz.print(new N0046().permute(arr));
    }

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();

    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    public void backtrack(int[] nums) {
        if (list.size() == nums.length)
            res.add(new ArrayList<>(list));

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            list.addLast(nums[i]);
            backtrack(nums);
            list.removeLast();
            used[i] = false;
        }
    }
}
