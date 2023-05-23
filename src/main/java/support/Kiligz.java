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
     * n个str -> ListNode
     */
    public static ListNode toListNode(String str) {
        ListNode head = new ListNode();
        ListNode cur = head;
        for (String val : str.split(",")) {
            cur = cur.next = new ListNode(Integer.parseInt(val));
        }
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
