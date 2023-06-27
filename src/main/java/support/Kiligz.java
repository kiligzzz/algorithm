package support;

import com.sun.tools.javac.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Ivan
 * @since 2023/2/27
 */
@SuppressWarnings("all")
public class Kiligz {

    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(int[][] arr) {
        System.out.println(Arrays.deepToString(arr));
    }

    public static <T> void print(T[] arr) {
        System.out.println(Arrays.deepToString(arr));
    }

    public static void print(ListNode head) {
        // 环形入口
        ListNode circleAccess = BasicUtil.getCircleAccess(head);

        List<ListNode> nodeList = new ArrayList<>();
        ListNode cur = head;
        boolean hasCircle = false;
        while (cur != null) {
            if (cur == circleAccess) {
                if (hasCircle) break;

                hasCircle = true;
            }
            nodeList.add(cur);
            cur = cur.next;
        }

        System.out.println(
                nodeList.stream()
                        .map(node -> node.val + "")
                        .collect(Collectors.joining(" -> "))
        );

        if (hasCircle)
            System.out.println("circleAccessIdx: " + nodeList.indexOf(circleAccess));
    }

    public static void print(Tree tree) {
        TreeUtil.show(tree);
    }

    public static void print(Node35 head) {
        List<Node35> nodeList = new ArrayList<>();
        Node35 cur = head;
        while (cur != null) {
            nodeList.add(cur);
            cur = cur.next;
        }

        System.out.println(
                nodeList.stream()
                        .map(node -> node.val + "")
                        .collect(Collectors.joining(" -> "))
        );
        System.out.println(
                nodeList.stream()
                        .filter(node -> node.random != null)
                        .map(node -> node.val + " -> " + node.random.val)
                        .collect(Collectors.joining("\n"))
        );
    }

    public static void print(Node36 head) {
        List<Node36> ascList = new ArrayList<>();
        ascList.add(head);
        Node36 cur = head.right;
        while (cur != null) {
            if (cur == head) break;
            ascList.add(cur);
            cur = cur.right;
        }
        List<Node36> descList = new ArrayList<>();
        cur = head.left;
        while (cur != null) {
            descList.add(cur);
            if (cur == head) break;
            cur = cur.left;
        }
        System.out.println("asc: " +
                ascList.stream()
                        .map(node36 -> node36.val + "")
                        .collect(Collectors.joining(" -> "))
        );
        System.out.println("desc: " +
                descList.stream()
                        .map(node36 -> node36.val + "")
                        .collect(Collectors.joining(" -> "))
        );
        if (ascList.get(0) == descList.get(descList.size() - 1)) {
            System.out.println("head: " + ascList.get(0).val);
        }
    }

    /**
     * str -> CharArray
     */
    public static char[] toCharArray(String str) {
        String[] strArr = str.split(",");
        char[] arr = new char[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = strArr[i].charAt(0);
        }
        return arr;
    }

    /**
     * str -> MatrixCharArray
     */
    public static char[][] toMatrixCharArray(String... strArr) {
        char[][] arr = new char[strArr.length][];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = toCharArray(strArr[i]);
        }
        return arr;
    }

    /**
     * str -> IntArray
     */
    public static int[] toIntArray(String str) {
        return Arrays.stream(str.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    /**
     * n个str -> MatrixIntArray
     */
    public static int[][] toMatrixIntArray(String... strArr) {
        int[][] arr = new int[strArr.length][];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = toIntArray(strArr[i]);
        }
        return arr;
    }

    /**
     * n个str -> Array
     */
    public static String[] toArray(String... strArr) {
        return strArr;
    }

    /**
     * n个str -> List
     */
    public static List<String> toList(String... strArr) {
        return Arrays.asList(strArr);
    }

    /**
     * n个str1，n个str2，交点前skip1个节点，交点前skip2个节点 -> ListNode，有交点的ListNode
     */
    public static Pair<ListNode, ListNode> toIntersectListNode(String str1, String str2, int skip1, int skip2) {
        ListNode head1 = toListNode(str1);
        ListNode head2 = toListNode(str2);

        ListNode cur1 = head1;
        for (int i = 0; i < skip1; i++) {
            cur1 = cur1.next;
        }

        ListNode cur2 = head2;
        for (int i = 0; i < skip2 - 1; i++) {
            cur2 = cur2.next;
        }
        cur2.next = cur1;

        return Pair.of(head1, head2);
    }

    /**
     * n个str -> ListNode，传入环形入口可构建环形链表
     */
    public static ListNode toListNode(String str) {
        return toListNode(str, -1);
    }

    /**
     * n个str -> ListNode，传入环形入口下标可构建环形链表
     */
    public static ListNode toListNode(String str, int circleAccessIdx) {
        ListNode head = new ListNode();
        ListNode access = null;

        ListNode cur = head;
        String[] arr = str.split(",");
        for (int i = 0; i < arr.length; i++) {
            cur = cur.next = new ListNode(Integer.parseInt(arr[i]));
            if (i == circleAccessIdx)
                access = cur;
        }
        cur.next = access;
        return head.next;
    }

    /**
     * n个value -> TreeNode
     * 如"1,null,2,3"
     *      1
     *       \
     *        2
     *       /
     *      3
     */
    public static TreeNode toTreeNode(String str) {
        return (TreeNode) TreeUtil.toTree(str.split(","), 0, TreeNode::new);
    }

    /**
     * str -> Node35
     */
    public static Node35 toNode35(String str) {
        str = str.replace("[", "").replace("]", "");
        String[] valAndIdxArr = str.split(",");

        Node35 head = new Node35(Integer.parseInt(valAndIdxArr[0]));

        Node35 cur = head;
        List<Node35> nodeList = new ArrayList<>();
        nodeList.add(cur);
        List<String> randomList = new ArrayList<>();
        for (int i = 1; i < valAndIdxArr.length; i++) {
            if (i % 2 == 0) {
                cur = cur.next = new Node35(Integer.parseInt(valAndIdxArr[i]));
                nodeList.add(cur);
            } else {
                randomList.add(valAndIdxArr[i]);
            }
        }

        for (int i = 0; i < nodeList.size(); i++) {
            String randomIdx = randomList.get(i);
            if (!"null".equals(randomIdx)) {
                Node35 node = nodeList.get(i);
                node.random = nodeList.get(Integer.parseInt(randomIdx));
            }
        }
        return head;
    }

    /**
     * str -> Node36(二叉树)
     */
    public static Node36 toNode36(String str) {
        return (Node36) TreeUtil.toTree(str.split(","), 0, Node36::new);
    }
}
