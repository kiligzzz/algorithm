package medium;

import support.Kiligz;
import support.TreeNode;
import type.DataStructure;
import type.DivideAndConquer;
import type.Recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序和后序遍历序列构造二叉树
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 *
 * @author Ivan
 * @since 2023/5/24
 */
public class N0106 implements DataStructure.BinaryTree, Recursive, DivideAndConquer {
    public static void main(String[] args) {
        int[] inorder = Kiligz.toIntArray("9,3,15,20,7");
        int[] postorder = Kiligz.toIntArray("9,15,7,20,3");
        Kiligz.print(new N0106().buildTree(inorder, postorder));
    }

    Map<Integer, Integer> map = new HashMap<>();

    int[] postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        this.postorder = postorder;
        return buildTree( 0, n - 1, n - 1);
    }

    public TreeNode buildTree(int pStart, int pEnd, int iEnd) {
        if (pStart > pEnd) return null;

        int rootVal = postorder[pEnd];
        int iRootIdx = map.get(rootVal);
        int rightNum = iEnd - iRootIdx;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(pStart, pEnd - rightNum - 1, iRootIdx - 1);
        root.right = buildTree(pEnd - rightNum, pEnd - 1, iEnd);
        return root;
    }
}
