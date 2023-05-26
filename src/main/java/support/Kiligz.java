package support;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Ivan
 * @since 2023/2/27
 */
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

    public static void print(TreeNode tree) {
        TreeUtil.show(tree);
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
     * str -> 2DCharArray
     */
    public static char[][] to2DCharArray(String... strArr) {
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
     * n个str -> 2DIntArray
     */
    public static int[][] to2DIntArray(String... strArr) {
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
        return TreeUtil.toTree(str.split(","), 0);
    }
}
