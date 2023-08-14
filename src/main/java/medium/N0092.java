package medium;

import support.ListNode;
import support.Kiligz;
import type.DataStructure;
import type.TwoPointer;

/**
 * 反转链表II
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 *
 * @author Ivan
 * @since 2023/5/15
 */
public class N0092 implements DataStructure.Linked, TwoPointer {
    public static void main(String[] args) {
        ListNode head = Kiligz.toListNode("1,2,3,4,5");
        Kiligz.print(new N0092().reverseBetween(head, 2, 4));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode pre = new ListNode(-1, head);
        ListNode cur = pre;
        int i = 0;
        while (i < left - 1) {
            cur = cur.next;
            i++;
        }
        // 记录左边不需要反转的最后位置
        ListNode reverseLeft = cur;
        // 记录需要反转的链表的开始位置
        ListNode reverseHead = cur.next;
        while (i < right) {
            cur = cur.next;
            i++;
        }
        // 记录右边不需要反转的开始位置
        ListNode reverseRight = cur.next;
        // 切断链表
        cur.next = null;
        // 反转链表
        reverseLeft.next = reverse(reverseHead);
        // 原来的头结点就是反转后的尾节点
        reverseHead.next = reverseRight;
        return pre.next;
    }

    public ListNode reverse(ListNode head) {
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
