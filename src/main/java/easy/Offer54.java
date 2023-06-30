package easy;

import support.Kiligz;
import support.TreeNode;
import type.DFS;
import type.DataStructure;
import type.Recursive;

/**
 * 二叉搜索树的第k大节点
 * 输入: root = [3,1,4,null,2], k = 1
 * 输出: 4
 *
 * @author Ivan
 * @since 2023/6/28
 */
public class Offer54 implements DataStructure.BinaryTree.BinarySearchTree, Recursive, DFS {
    public static void main(String[] args) {
        TreeNode root = Kiligz.toTreeNode("3,1,4,null,2");
        Kiligz.print(new Offer54().kthLargest(root, 1));
    }

    int res;
    int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.right);
        if (--k == 0) {
            res = root.val;
            return;
        }
        inorder(root.left);
    }
}
