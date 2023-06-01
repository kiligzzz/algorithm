package type;

import support.TreeNode;

import java.util.LinkedList;

/**
 * 深度优先
 * 主要用于搜索和遍历
 *
 * @author Ivan
 * @since 2023/5/17
 */
public interface DFS {
    /**
     * 回溯，DFS的一种特殊形式，会回头
     */
    interface Backtrack extends DFS {
        /**
         * 回溯基本格式
         */
        default void backtrack(int[] nums, int i, LinkedList<Integer> res) {
            if (i == nums.length - 1)
                return;

            res.addLast(nums[i]);
            backtrack(nums, i + 1, res);
            res.removeLast();
        }
    }

    /**
     * 深度优先基本格式
     */
    default void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
    }
}
