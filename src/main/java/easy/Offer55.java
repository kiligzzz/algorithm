package easy;

import support.Kiligz;
import support.TreeNode;
import type.DFS;
import type.DataStructure;
import type.Recursive;

/**
 * 二叉树的深度 & 平衡二叉树
 *
 * 输入：[3,9,20,null,null,15,7]
 * 输出：3
 *
 * 输入：[3,9,20,null,null,15,7]
 * 输出：true
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
 *
 * @author Ivan
 * @since 2023/6/28
 */
public class Offer55 implements DataStructure.BinaryTree, Recursive, DFS {
    public static void main(String[] args) {
        TreeNode root = Kiligz.toTreeNode("3,9,20,null,null,15,7");
        Kiligz.print(new Offer55().isBalanced(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(
                maxDepth(root.left), maxDepth(root.right));
    }


    boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return isBalanced;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        if (Math.abs(lDepth - rDepth) > 1)
            isBalanced = false;
        return 1 + Math.max(lDepth, rDepth);
    }
}
