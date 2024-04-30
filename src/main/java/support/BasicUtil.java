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

    /**
     * 快排
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速幂
     */
    public double quickPow(double x, int n) {
        return n >= 0 ?
                pow(x, n) : 1 / pow(x, -n);
    }

    /**
     * 快速幂
     */
    private double pow(double x, int n) {
        if (n == 0) return 1;

        double v = pow(x, n / 2);
        return n % 2 == 0 ? v * v : v * v * x;
    }

    /**
     * 快排
     */
    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && arr[r] >= arr[left]) r--;
            while (l < r && arr[l] <= arr[right]) l++;

            swap(arr, l, r);
        }
        swap(arr, l, left);
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
    }

    /**
     * 交换元素位置
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * k个一组链表反转
     */
    public static ListNode reverseK(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // 创建一个虚拟头节点，方便后续操作
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // 计算链表的长度
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // 进行k个一组的反转
        while (count >= k) {
            curr = head;
            ListNode next = null;

            // 反转k个节点
            for (int i = 1; i <= k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // 将反转后的部分连接到链表的其余部分
            head.next = curr;
            prev.next = null;
            head = prev;

            // 更新计数器
            count -= k;
        }

        return dummy.next;
    }
}
