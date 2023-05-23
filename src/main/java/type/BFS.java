package type;

import support.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 广度优先
 *
 * @author Ivan
 * @date 2023/5/17 18:51
 */
public interface BFS {
    /**
     * 广度优先基本格式
     */
    default void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }
}
