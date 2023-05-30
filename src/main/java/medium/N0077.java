package medium;

import support.Kiligz;
import type.CSF;
import type.DFS;
import type.Recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 * 无重不可复用，不能有重复结果
 * 所有可能的k个数组合
 * 输入：n = 4, k = 2
 * 输出：[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 *
 * @author Ivan
 * @since 2023/4/25
 */
public class N0077 implements CSF.Combination, DFS.Backtrack, Recursive {
    public static void main(String[] args) {
        Kiligz.print(new N0077().combine(4, 2));
    }

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return res;
    }

    public void backtrack(int n, int k, int start) {
        if (k == 0)
            res.add(new ArrayList<>(list));

        for (int i = start; i <= n; i++) {
            if (k == 0) return;

            list.addLast(i);
            backtrack(n, k - 1, i + 1);
            list.removeLast();
        }
    }
}
