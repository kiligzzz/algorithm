package easy;

import support.Kiligz;
import support.TreeNode;
import type.DFS;
import type.DataStructure;
import type.Recursive;

/**
 * 对称二叉树
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * @author Ivan
 * @since 2023/5/17
 */
public class N0101 implements DataStructure.BinaryTree, Recursive, DFS {
    public static void main(String[] args) {
        TreeNode root = Kiligz.toTreeNode("1,2,2,3,4,4,3");
        Kiligz.print(root);
        Kiligz.print(new N0101().isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val
                && dfs(left.left, right.right)
                && dfs(left.right, right.left);
    }
}
