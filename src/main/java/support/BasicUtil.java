package support;

/**
 * 基础算法
 *
 * @author Ivan
 * @since 2023/4/3
 */
public class BasicUtil {
    /**
     * 二分查找（需有序状态）
     */
    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                l = mid;
            else
                r = mid;
        }
        return -1;
    }

    /**
     * 获取环形链表的入口
     *
     * 设A为头节点到环入口的距离，B为环的长度，C为从环入口到相遇点的距离, D为从相遇点到环入口的距离
     * 1.当slow走到环形入口时，fast在环内任意位置，fast与slow的距离为length，可知length < B
     *  - 避免永远相遇不了，fast速度只能小于等于B
     * 2.fast比slow多走一步，所以每次距离变为length-1，不到一圈就能相遇
     * 3.环形入口？当两个指针相遇时
     *  - 慢：S = A + C  快：2S = A + C + nB
     *  - 可得A = nB - C 而 B = C + D
     *  - 可得A = (n - 1)B + D
     *  - 可以理解为
     *      - 左边是一个指针从头开始走了A的距离到了环入口
     *      - 右边是一个指针从相遇点先走D的距离，到达环入口，然后又走了n个B的距离，还是在环入口
     *
     */
    public static ListNode getCircleAccess(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
