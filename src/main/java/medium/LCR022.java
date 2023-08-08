package medium;

import support.Kiligz;
import support.ListNode;
import type.DataStructure;
import type.TwoPointer;

/**
 * 环形链表II
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回环形链表的入口
 *
 * @author Ivan
 * @since 2023/8/8
 */
public class LCR022 implements DataStructure.Linked,TwoPointer.FastSlowPointer {
    public static void main(String[] args) {
        ListNode head = Kiligz.toListNode("3,2,0,-4", 1);
        Kiligz.print(head);
        Kiligz.print(new LCR022().detectCycle(head));
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null)
            return null;

        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
