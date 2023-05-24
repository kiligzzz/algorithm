package easy;

import support.Kiligz;
import support.TreeNode;
import type.DFS;
import type.DataStructure;
import type.Recursive;

/**
 * 二叉树的最大深度
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 *
 * @author Ivan
 * @since 2023/5/18
 */
public class N0104 implements DataStructure.BinaryTree, Recursive, DFS {
    public static void main(String[] args) {
        TreeNode root = Kiligz.toTreeNode("3,9,20,null,null,15,7");
        Kiligz.print(new N0104().maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return 1 + Math.max(
                maxDepth(root.left), maxDepth(root.right));
    }
}
