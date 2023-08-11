package medium;

import support.Kiligz;
import support.ListNode;
import type.DataStructure;
import type.TwoPointer;

/**
 * 两数相加II
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 *
 * @author Ivan
 * @since 2023/8/10
 */
public class LCR025 implements DataStructure.Linked, TwoPointer {
    public static void main(String[] args) {
        ListNode l1 = Kiligz.toListNode("7,2,4,3");
        ListNode l2 = Kiligz.toListNode("5,6,4");
        Kiligz.print(new LCR025().addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode pre = new ListNode();
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = 0, v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }

            int sum = v1 + v2 + carry;
            cur = cur.next = new ListNode(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return reverse(pre.next);
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
}
