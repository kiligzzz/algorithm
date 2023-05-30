package medium;

import support.Kiligz;
import type.CSF;
import type.DFS;
import type.Recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和
 * 无重可复用，不能有重复结果
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 *
 * @author Ivan
 * @since 2023/4/24
 */
public class N0039 implements CSF.Combination, DFS.Backtrack, Recursive {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("2,3,6,7");
        Kiligz.print(new N0039().combinationSum(arr, 7));
    }

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start) {
        if (target == 0)
            res.add(new ArrayList<>(list));

        for (int i = start; i < candidates.length; i++) {
            int c = candidates[i];
            // 剪枝
            if (c > target) continue;

            list.addLast(c);
            backtrack(candidates, target - c, i);
            list.removeLast();
        }
    }
}
