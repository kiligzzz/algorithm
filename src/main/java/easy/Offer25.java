package easy;

import support.Kiligz;
import support.ListNode;
import type.DataStructure;
import type.Recursive;

/**
 * 合并两个排序的链表
 * 输入：[1,2,4], [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * @author Ivan
 * @since 2023/6/6
 */
public class Offer25 implements DataStructure.Linked, Recursive {
    public static void main(String[] args) {
        ListNode l1 = Kiligz.toListNode("1,2,4");
        ListNode l2 = Kiligz.toListNode("1,3,4");
        Kiligz.print(new Offer25().mergeTwoLists(l1, l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
