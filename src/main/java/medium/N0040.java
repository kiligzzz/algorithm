package medium;

import support.Kiligz;
import type.CSF;
import type.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和II
 * 有重不可复用，不能有重复结果
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出: [[1,2,2],[5]]
 *
 * @author Ivan
 * @since 2023/4/24
 */
public class N0040 implements CSF.Combination, DFS.Backtrack {

    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("2,5,2,1,2");
        Kiligz.print(new N0040().combinationSum2(arr, 5));
    }

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    public void backtrack(int[] candidates, int target, int start) {
        if (target == 0)
            res.add(new ArrayList<>(list));

        for (int i = start; i < candidates.length; i++) {
            int c = candidates[i];
            // 剪枝
            // c > target则放弃之后的循环递归
            if (c > target) return;
            // 重复的跳过
            if (i > start && c == candidates[i - 1])
                continue;

            list.addLast(c);
            backtrack(candidates, target - c, i + 1);
            list.removeLast();
        }
    }
}
