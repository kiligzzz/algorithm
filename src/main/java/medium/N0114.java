package medium;

import support.Kiligz;
import support.TreeNode;
import type.DFS;
import type.DataStructure;
import type.Recursive;

/**
 * 二叉树展开为链表(前序)
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 *
 * @author Ivan
 * @since 2023/5/24
 */
public class N0114 implements DataStructure.BinaryTree, Recursive, DFS {
    public static void main(String[] args) {
        TreeNode root = Kiligz.toTreeNode("1,2,5,3,4,null,6");
        new N0114().flatten(root);
        Kiligz.print(root);
    }

    // 已经展开的
    TreeNode flattened = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = flattened;
        root.left = null;
        flattened = root;
    }
}
