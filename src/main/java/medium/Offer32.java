package medium;

import support.Kiligz;
import support.TreeNode;
import type.BFS;
import type.DataStructure;

import java.util.*;

/**
 * 从上到下打印二叉树I & II & III
 * 输入：[3,9,20,null,null,15,7],
 * 输出：
 *   I：[3,9,20,15,7]
 *  II：[[3],[9,20],[15,7]]
 * III：[[3],[20,9],[15,7]]
 *
 * @author Ivan
 * @since 2023/6/8
 */
public class Offer32 implements DataStructure.BinaryTree, BFS {
    public static void main(String[] args) {
        TreeNode root = Kiligz.toTreeNode("3,9,20,null,null,15,7");
        Kiligz.print(root);
        Kiligz.print(new Offer32().levelOrder3(root));
    }

    public int[] levelOrder1(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> resList = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            resList.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        boolean l2r = true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (l2r) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(list);
            l2r = !l2r;
        }
        return res;
    }
}
