package easy;

import support.Kiligz;
import support.TreeNode;
import type.DFS;
import type.DataStructure;
import type.Recursive;

/**
 * 二叉搜索树的最近公共祖先 & 二叉树的最近公共祖先
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 *
 * @author Ivan
 * @since 2023/7/5
 */
public class Offer68 implements DataStructure.BinaryTree.BinarySearchTree, DFS, Recursive {
    public static void main(String[] args) {
//        TreeNode root = Kiligz.toTreeNode("6,2,8,0,4,7,9,null,null,3,5");
//        TreeNode p = Kiligz.toTreeNode("2");
//        TreeNode q = Kiligz.toTreeNode("8");
//        Kiligz.print(new Offer68().lowestCommonAncestor(root, p, q));

        TreeNode root = Kiligz.toTreeNode("3,5,1,6,2,0,8,null,null,7,4");
        Kiligz.print(new Offer68().lowestCommonAncestor2(root, root.left, root.right));
    }

    /**
     * 二叉搜索树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }



    TreeNode ancestor;

    /**
     * 二叉树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        isAncestor(root, p, q);
        return ancestor;
    }

    private boolean isAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean al = isAncestor(root.left, p, q);
        boolean ar = isAncestor(root.right, p, q);
        boolean se = root == p || root == q;

        if (al && ar || (al || ar) && se) ancestor = root;

        return al || ar || se;
    }

    /**
     * 二叉树的最近公共祖先，更好
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode al = lowestCommonAncestor2(root.left, p, q);
        TreeNode ar = lowestCommonAncestor2(root.right, p, q);
        if(al == null && ar == null) return null;
        if(al == null) return ar;
        if(ar == null) return al;
        return root;
    }

}
