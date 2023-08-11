package medium;

import support.Kiligz;
import support.ListNode;
import type.DataStructure;
import type.TwoPointer;

/**
 * 重排链表
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,5,2,4,3]
 * 1,2,3...,n-1,n
 * 1,n,2,n-1...
 *
 * @author Ivan
 * @since 2023/8/11
 */
public class LCR026 implements DataStructure.Linked, TwoPointer.FastSlowPointer {
    public static void main(String[] args) {
        ListNode head = Kiligz.toListNode("1,2,3,4");
        new LCR026().reorderList(head);
        Kiligz.print(head);
    }

    public void reorderList(ListNode head) {
        ListNode mid = mid(head);
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverse(l2);
        merge(head, l2);
    }

    private ListNode mid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = head;
        ListNode cur = null;
        while (pre != null) {
            ListNode temp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = temp;
        }
        return cur;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode temp = l1.next;
            l1.next = l2;
            l1 = temp;

            temp = l2.next;
            l2.next = l1;
            l2 = temp;
        }
    }
}
