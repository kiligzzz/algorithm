package easy;

import support.Kiligz;
import support.ListNode;
import type.DataStructure;

/**
 * 删除链表的节点
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 *
 * @author Ivan
 * @since 2023/6/1
 */
public class Offer18 implements DataStructure.Linked {
    public static void main(String[] args) {
        ListNode head = Kiligz.toListNode("4,5,1,9");
        Kiligz.print(new Offer18().deleteNode(head, 5));
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val)
            return head.next;

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
