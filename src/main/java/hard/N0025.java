package hard;

import support.Kiligz;
import support.ListNode;
import type.DataStructure;
import type.TwoPointer;

/**
 * k个一组链表反转
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 *
 * @author Ivan
 * @since 2024/4/17
 */
public class N0025 implements DataStructure.Linked, TwoPointer {
    public static void main(String[] args) {
        ListNode head = Kiligz.toListNode("1,2,3,4,5");
        Kiligz.print(new N0025().reverseKGroup(head, 2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count < k) {
            cur = cur.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        ListNode pre = null;
        cur = head;
        for (int i = count; i > 0; i--) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = reverseKGroup(cur, k);
        return pre;
    }
}
