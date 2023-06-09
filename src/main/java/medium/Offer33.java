package medium;

import support.Kiligz;
import type.DataStructure;
import type.Recursive;

/**
 * 二叉搜索树的后序遍历序列
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * @author Ivan
 * @since 2023/6/9
 */
public class Offer33 implements DataStructure.BinaryTree.BinarySearchTree, Recursive {
    public static void main(String[] args) {
        int[] postorder = Kiligz.toIntArray("1,3,2,6,5");
        Kiligz.print(Kiligz.toTreeNode("5,2,6,1,3"));
        Kiligz.print(new Offer33().verifyPostorder(postorder));
    }

    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    boolean verify(int[] postorder, int l, int r) {
        if(l >= r) return true;
        int i = l;
        // 找到右子节点的位置，能保证前面的（也就是左子树）都比父节点小
        while(postorder[i] < postorder[r]) i++;
        int rIdx = i;
        // 找到右子树中最大节点的位置
        while(postorder[i] > postorder[r]) i++;
        return i == r
                && verify(postorder, l, rIdx - 1)
                && verify(postorder, rIdx, r - 1);
    }
}

