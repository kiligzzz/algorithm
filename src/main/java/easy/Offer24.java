package easy;

import support.Kiligz;
import support.ListNode;
import type.DataStructure;

/**
 * 反转链表
 * 输入: [1,2,3,4,5]
 * 输出: [5,4,3,2,1]
 *
 * @author Ivan
 * @since 2023/6/5
 */
public class Offer24 implements DataStructure.Linked {
    public static void main(String[] args) {
        ListNode head = Kiligz.toListNode("1,2,3,4,5");
        Kiligz.print(new Offer24().reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
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
