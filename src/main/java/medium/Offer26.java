package medium;

import support.Kiligz;
import support.TreeNode;
import type.DFS;
import type.DataStructure;
import type.Recursive;

/**
 * 树的子结构
 * 输入：[3,4,5,1,2,null,null] ，[4,1,null]
 * 输出：true
 *
 * @author Ivan
 * @since 2023/6/6
 */
public class Offer26 implements DataStructure.BinaryTree, DFS, Recursive {
    public static void main(String[] args) {
        TreeNode A = Kiligz.toTreeNode("3,4,5,1,2,null,null");
        TreeNode B = Kiligz.toTreeNode("4,1,null");
        Kiligz.print(new Offer26().isSubStructure(A, B));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        return isSub(A, B)
                || isSubStructure(A.left, B)
                || isSubStructure(A.right, B);
    }

    private boolean isSub(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null || A.val != B.val)
            return false;
        return isSub(A.left, B.left)
                && isSub(A.right, B.right);
    }
}
