package easy;

import com.sun.tools.javac.util.Pair;
import support.Kiligz;
import support.ListNode;
import type.DataStructure;

/**
 * 相交链表
 * 输入：listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：相交节点
 *
 * @author Ivan
 * @since 2023/8/8
 */
public class LCR023 implements DataStructure.Linked {
    public static void main(String[] args) {
        Pair<ListNode, ListNode> pair = Kiligz.toIntersectListNode("4,1,8,4,5", "5,0,1,8,4,5", 2, 3);
        Kiligz.print(new LCR023().getIntersectionNode(pair.fst, pair.snd));
    }

    /**
     * a为A链表不相交长度，b为B链表不相交长度，c为相交长度
     * lA：a + c + b
     * lB：b + c + a
     * 此时就会同时到达相交位置
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode lA = headA, lB = headB;
        while (lA != lB) {
            lA = lA != null ? lA.next : headB;
            lB = lB != null ? lB.next : headA;
        }
        return lA;
    }
}
