package medium;

import support.Kiligz;
import support.TreeNode;
import type.BFS;
import type.DataStructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 *
 * @author Ivan
 * @since 2023/5/17
 */
public class N0102 implements DataStructure.BinaryTree, BFS {
    public static void main(String[] args) {
        TreeNode root = Kiligz.toTreeNode("3,9,20,null,null,15,7");
        Kiligz.print(root);
        Kiligz.print(new N0102().levelOrder(root));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        bfs(root);
        return res;
    }

    public void bfs(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            res.add(list);
        }
    }
}
