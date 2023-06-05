package easy;

import support.Kiligz;
import support.ListNode;
import type.DataStructure;
import type.TwoPointer;

/**
 * 链表中倒数第k个节点
 * 输入: [1,2,3,4,5], k = 2
 * 输出: [4,5]
 *
 * @author Ivan
 * @since 2023/6/2
 */
public class Offer22 implements DataStructure.Linked, TwoPointer.FastSlowPointer {
    public static void main(String[] args) {
        ListNode head = Kiligz.toListNode("1,2,3,4,5");
        Kiligz.print(new Offer22().getKthFromEnd(head, 2));
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
