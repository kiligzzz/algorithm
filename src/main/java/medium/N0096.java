package medium;

import support.Kiligz;
import type.DataStructure;
import type.DynamicProgramming;
import type.Recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * 不同的二叉搜索树
 * 输入：n = 3
 * 输出：5
 *
 * @author Ivan
 * @since 2023/5/15
 */
public class N0096 implements DataStructure.BinaryTree.BinarySearchTree,
        DynamicProgramming, Recursive {
    public static void main(String[] args) {
        Kiligz.print(new N0096().numTrees(3));
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                // n的值为i时，j作为根节点时，左右子树数相乘
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
     }

    Map<Integer, Integer> map = new HashMap<>();

    public int numTrees1(int n) {
        if (n <= 1)
            return 1;
        if (map.containsKey(n))
            return map.get(n);
        int num = 0;
        for (int i = 1; i <= n; i++) {
            // i作为根节点时，左边右边子树数相乘
            int left = numTrees(i - 1);
            int right = numTrees(n - i);
            num += left * right;
        }
        map.put(n, num);
        return num;
    }
}
