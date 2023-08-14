package medium;

import support.Kiligz;
import support.ListNode;

/**
 * 循环有序列表的插入
 * 输入：head = [3,4,1], insertVal = 2
 * 输出：[3,4,1,2]
 *
 * @author Ivan
 * @since 2023/8/14
 */
public class LCR029 {
    public static void main(String[] args) {
        ListNode head = Kiligz.toListNode("3,4,1", 0);
        Kiligz.print(new LCR029().insert(head, 2));
    }

    public ListNode insert(ListNode head, int insertVal) {
        if (head == null) {
            ListNode node = new ListNode(insertVal);
            node.next = node;
            return node;
        }
        if (head.next == head) {
            head.next = new ListNode(insertVal, head);
            return head;
        }

        ListNode cur = head, next = head.next;
        while (next != head) {
            if (insertVal >= cur.val && insertVal <= next.val) {
                break;
            }
            if (cur.val > next.val) {
                if (insertVal > cur.val || insertVal < next.val) {
                    break;
                }
            }
            cur = cur.next;
            next = next.next;
        }
        cur.next = new ListNode(insertVal, next);
        return head;
    }
}
