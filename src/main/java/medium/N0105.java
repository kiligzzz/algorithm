package medium;

import support.Kiligz;
import support.TreeNode;
import type.DataStructure;
import type.DivideAndConquer;
import type.Recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 *
 * @author Ivan
 * @since 2023/5/19
 */
public class N0105 implements DataStructure.BinaryTree, Recursive, DivideAndConquer {
    public static void main(String[] args) {
        int[] preorder = Kiligz.toIntArray("3,9,20,15,7");
        int[] inorder = Kiligz.toIntArray("9,3,15,20,7");
        Kiligz.print(new N0105().buildTree(preorder, inorder));
    }

    Map<Integer, Integer> map = new HashMap<>();

    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        this.preorder = preorder;
        return buildTree(0, n - 1, 0);
    }

    public TreeNode buildTree(int pStart, int pEnd, int iStart) {
        if (pStart > pEnd) return null;

        int rootVal = preorder[pStart];
        int iRootIdx = map.get(rootVal);
        int leftNum = iRootIdx - iStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(pStart + 1, pStart + leftNum, iStart);
        root.right = buildTree(pStart + leftNum + 1, pEnd, iRootIdx + 1);
        return root;
    }
}
