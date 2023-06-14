package medium;

import support.Kiligz;
import support.Node36;
import support.Tree;
import type.DFS;
import type.DataStructure;
import type.Recursive;

/**
 * 二叉搜索树与双向链表
 * 输入：[4,2,5,1,3]
 * 输出：双向循环链表
 *
 * @author Ivan
 * @since 2023/6/12
 */
public class Offer36 implements DataStructure.BinaryTree.BinarySearchTree, DFS, Recursive {
    public static void main(String[] args) {
        Node36 root = Kiligz.toNode36("4,2,5,1,3");
        Kiligz.print((Tree<Node36>) root);
        Kiligz.print(new Offer36().treeToDoublyList(root));
    }

    Node36 pre;
    Node36 head;

    public Node36 treeToDoublyList(Node36 root) {
        if (root == null) return null;

        dfs(root);
        head.left = pre;
        pre.right = head;

        return head;
    }

    void dfs(Node36 cur) {
        if (cur == null) return;

        dfs(cur.left);

        if (pre == null)
            // 二叉搜索树最左下叶子结点作为head
            head = cur;
        else
            // 将当前节点设置为前一个的后节点
            pre.right = cur;
        // 将前一个设置为当前节点的左节点
        cur.left = pre;
        // 往右移动指针
        pre = cur;

        dfs(cur.right);
    }
}
