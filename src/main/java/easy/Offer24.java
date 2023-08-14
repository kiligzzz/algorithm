package easy;

import support.Kiligz;
import support.ListNode;
import type.DataStructure;
import type.TwoPointer;

/**
 * 反转链表
 * 输入: [1,2,3,4,5]
 * 输出: [5,4,3,2,1]
 *
 * @author Ivan
 * @since 2023/6/5
 */
public class Offer24 implements DataStructure.Linked, TwoPointer {
    public static void main(String[] args) {
        ListNode head = Kiligz.toListNode("1,2,3,4,5");
        Kiligz.print(new Offer24().reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
