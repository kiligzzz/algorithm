package medium;

import support.ListNode;
import support.Kiligz;
import type.DataStructure;

/**
 * 两数相加
 * 输入：l1 = [2,4,3], l2 = [5,6,4] 输出：[7,0,8]
 *
 * @author Ivan
 * @since 2023/2/27
 */
public class N0002 implements DataStructure.Linked {
    public static void main(String[] args) {
        ListNode l1 = Kiligz.toListNode("2,4,3");
        ListNode l2 = Kiligz.toListNode("5,6,4");
        Kiligz.print(new N0002().addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = 0;
            int v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }

            int sum = v1 + v2 + carry;
            cur = cur.next = new ListNode();
            cur.val = sum % 10;
            carry = sum / 10;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }
}
