package easy;

import com.sun.tools.javac.util.Pair;
import support.Kiligz;
import support.ListNode;
import type.Common;
import type.TwoPointer;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个链表的第一个公共节点
 * 输入：A=[4,1,8,4,5], B=[5,0,1,8,4,5], skipA=2, skipB=3
 * 输出：8
 *
 * @author Ivan
 * @since 2023/6/26
 */
public class Offer52 implements TwoPointer, Common.Hash {
    public static void main(String[] args) {
        Pair<ListNode, ListNode> pair = Kiligz.toIntersectListNode("4,1,8,4,5", "5,0,1,8,4,5", 2, 3);
        Kiligz.print(new Offer52().getIntersectionNode(pair.fst, pair.snd));
    }

    /**
     * a为A链表不相交长度，b为B链表不相交长度，c为相交长度
     * pA：a + c + b
     * pB：b + c + a
     * 此时就会同时到达相交位置
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }
        return pA;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }

        cur = headB;
        while (cur != null) {
            if (!set.add(cur)) return cur;
            cur = cur.next;
        }
        return null;
    }
}
