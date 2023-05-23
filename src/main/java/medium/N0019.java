package medium;

import support.ListNode;
import support.Kiligz;
import type.DataStructure;
import type.TwoPointer;

/**
 * 删除链表的倒数第N个节点
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * @author Ivan
 * @since 2023/4/11
 */
public class N0019 implements DataStructure.Linked, TwoPointer.FastSlowPointer {
    public static void main(String[] args) {
        ListNode head = Kiligz.toListNode("1,2,3,4,5");
        Kiligz.print(new N0019().removeNthFromEnd(head, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }
}
