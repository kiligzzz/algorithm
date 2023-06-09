package medium;

import support.Kiligz;
import support.TreeNode;
import type.DFS;
import type.DataStructure;
import type.Recursive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 *
 * @author Ivan
 * @since 2023/6/9
 */
public class Offer34 implements DataStructure.BinaryTree, DFS.Backtrack, Recursive {
    public static void main(String[] args) {
        TreeNode root = Kiligz.toTreeNode("5,4,8,11,null,13,4,7,2,null,null,null,null,5,1");
        Kiligz.print(root);
        Kiligz.print(new Offer34().pathSum(root, 22));
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        backtrack(root, target);
        return res;
    }

    private void backtrack(TreeNode root, int target) {
        if (root == null) return;

        list.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<>(list));
        }

        backtrack(root.left, target);
        backtrack(root.right, target);
        list.removeLast();
    }
}
