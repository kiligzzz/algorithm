package easy;

import support.Kiligz;
import support.ListNode;
import type.DataStructure;
import type.TwoPointer;

/**
 * 环形链表
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 *
 * @author Ivan
 * @since 2023/5/26
 */
public class N0141 implements DataStructure.Linked, TwoPointer.FastSlowPointer {
    public static void main(String[] args) {
        ListNode head = Kiligz.toListNode("3,2,0,-4", 1);
        Kiligz.print(new N0141().hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
