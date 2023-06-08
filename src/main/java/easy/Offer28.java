package easy;

import support.Kiligz;
import support.TreeNode;
import type.DFS;
import type.DataStructure;
import type.Recursive;

/**
 * 对称的二叉树
 * 输入：[1,2,2,3,4,4,3]
 * 输出：true
 *
 * @author Ivan
 * @since 2023/6/7
 */
public class Offer28 implements DataStructure.BinaryTree, DFS, Recursive {
    public static void main(String[] args) {
        TreeNode root = Kiligz.toTreeNode("1,2,2,3,4,4,3");
        Kiligz.print(new Offer28().isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val
                && check(left.left, right.right)
                && check(left.right, right.left);
    }
}
