package medium;

import support.Kiligz;
import support.Node35;
import type.Common;
import type.DataStructure;

import java.util.*;

/**
 * 复杂链表的复制
 * 每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * @author Ivan
 * @since 2023/6/12
 */
public class Offer35 implements DataStructure.Linked, Common.Hash {
    public static void main(String[] args) {
        Node35 head = Kiligz.toNode35("[7,null],[13,0],[11,4],[10,2],[1,0]");
        Kiligz.print(new Offer35().copyRandomList(head));
    }

    public Node35 copyRandomList(Node35 head) {
        if (head == null) return null;

        Node35 pre = new Node35(-1);
        Map<Node35, Node35> map = new HashMap<>();

        Node35 cur = head;
        Node35 copyCur = pre;
        while (cur != null) {
            copyCur = copyCur.next = new Node35(cur.val);
            map.put(cur, copyCur);
            cur = cur.next;
        }

        cur = head;
        copyCur = pre.next;
        while (cur != null) {
            copyCur.random = map.get(cur.random);
            cur = cur.next;
            copyCur = copyCur.next;
        }

        return pre.next;
    }
}
