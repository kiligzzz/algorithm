package medium;

import support.Kiligz;
import type.CSF;
import type.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和III
 * 无重不可复用，不能有重复结果
 * 只使用数字1到9
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 *
 * @author Ivan
 * @since 2023/4/24
 */
public class N0216 implements CSF.Combination, DFS.Backtrack {
    public static void main(String[] args) {
        Kiligz.print(new N0216().combinationSum3(3, 7));
    }

    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1);
        return res;
    }

    public void backtrack(int k, int n, int start) {
        if (n == 0 && k == 0)
            res.add(new ArrayList<>(list));

        for (int i = start; i <= 9; i++) {
            // 剪枝
            // 若剩余的k个i之和大于n（后面的只会比i大），则放弃之后的循环递归
            if (i * k > n || k == 0) return;

            list.addLast(i);
            backtrack(k - 1, n - i, i + 1);
            list.removeLast();
        }
    }
}
