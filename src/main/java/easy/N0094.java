package easy;

import support.Kiligz;
import support.TreeNode;
import type.DFS;
import type.DataStructure;
import type.Recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * @author Ivan
 * @since 2023/5/15
 */
public class N0094 implements DataStructure.BinaryTree, Recursive, DFS {
    public static void main(String[] args) {
        TreeNode root = Kiligz.toTreeNode("1,null,2,null,null,3");
        Kiligz.print(new N0094().inorderTraversal(root));
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        midTraversal(root);
        return res;
    }

    private void midTraversal(TreeNode root) {
        if (root == null) return;
        midTraversal(root.left);
        res.add(root.val);
        midTraversal(root.right);
    }
}
