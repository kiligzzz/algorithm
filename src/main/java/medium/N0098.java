package medium;

import support.Kiligz;
import support.TreeNode;
import type.DFS;
import type.DataStructure;
import type.Recursive;

/**
 * 验证二叉搜索树
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 *
 * @author Ivan
 * @since 2023/5/16
 */
public class N0098 implements DataStructure.BinaryTree.BinarySearchTree,
        Recursive, DFS {
    public static void main(String[] args) {
        TreeNode root = Kiligz.toTreeNode("5,4,6,null,null,3,7");
        Kiligz.print(root);
        Kiligz.print(new N0098().isValidBST(root));
    }

    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST(root.left)) return false;

        // 中序遍历，若当前节点值 <= 上一个节点值，则为false
        if (root.val <= pre) return false;
        pre = root.val;

        return isValidBST(root.right);
    }
}
