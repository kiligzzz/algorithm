package medium;

import support.Kiligz;
import support.TreeNode;
import type.DataStructure;
import type.Recursive;

/**
 * 重建二叉树
 * 输入: 前序 = [3,9,20,15,7], 中序 = [9,3,15,20,7]
 * 输出: 3
 *   9     20
 *       15   7
 *
 * @author Ivan
 * @since 2023/4/10
 */
public class Offer07 implements DataStructure.BinaryTree, Recursive {
    public static void main(String[] args) {
        int[] preorder = Kiligz.toIntArray("3,9,20,15,7");
        int[] inorder = Kiligz.toIntArray("9,3,15,20,7");
        Kiligz.print(new Offer07().buildTree(preorder, inorder));
    }

    private int pre = 0;
    private int in = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, null);
    }

    private TreeNode build(int[] preorder, int[] inorder, Integer endMarker) {
        if (pre == preorder.length)
            return null;
        // 结束标记，顶点或者null
        if (endMarker != null && inorder[in] == endMarker) {
            in++;
            return null;
        }

        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, endMarker);
        return node;
    }
}
