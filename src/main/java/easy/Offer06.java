package easy;

import support.ListNode;
import support.Kiligz;
import type.DataStructure;

/**
 * 从尾到头打印链表
 * 输入：head = [1,3,2] 输出：[2,3,1]
 *
 * @author Ivan
 * @since 2023/4/10
 */
public class Offer06 implements DataStructure.Linked {
    public static void main(String[] args) {
        ListNode head = Kiligz.toListNode("1,3,2");
        Kiligz.print(new Offer06().reversePrint(head));
    }

    public int[] reversePrint(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int[] res = new int[len];
        cur = head;
        while (cur != null) {
            res[--len] = cur.val;
            cur = cur.next;
        }
        return res;
    }
}
