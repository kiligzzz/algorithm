package easy;

import support.Kiligz;
import support.TreeNode;
import type.DFS;
import type.DataStructure;
import type.Recursive;

/**
 * 二叉树的镜像
 * 输入：[4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * @author Ivan
 * @since 2023/6/6
 */
public class Offer27 implements DataStructure.BinaryTree, DFS, Recursive {
    public static void main(String[] args) {
        TreeNode root = Kiligz.toTreeNode("4,2,7,1,3,6,9");
        Kiligz.print(root);
        Kiligz.print(new Offer27().mirrorTree(root));
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
