package medium;

import support.Kiligz;
import support.TreeNode;
import type.DataStructure;
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
public class N0105 implements DataStructure.BinaryTree, Recursive {
    public static void main(String[] args) {
        int[] preorder = Kiligz.toIntArray("3,9,20,15,7");
        int[] inorder = Kiligz.toIntArray("9,3,15,20,7");
        Kiligz.print(new N0105().buildTree(preorder, inorder));
    }

    Map<Integer, Integer> map = new HashMap<>();

    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int i = 0;
        for (int num : inorder) {
            map.put(num, i++);
        }
        return buildTree(0, i, 0);
    }

    public TreeNode buildTree(int pStart, int pEnd, int iStart) {
        if (pStart == pEnd) return null;

        int rootVal = preorder[pStart];
        int iRootIdx = map.get(rootVal);
        int leftNum = iRootIdx - iStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(pStart + 1, pStart + 1 + leftNum, iStart);
        root.right = buildTree(pStart + 1 + leftNum, pEnd, iRootIdx + 1);
        return root;
    }
}
