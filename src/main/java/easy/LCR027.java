package easy;

import support.Kiligz;
import support.ListNode;
import type.DataStructure;
import type.TwoPointer;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 *
 * @author Ivan
 * @since 2023/8/14
 */
public class LCR027 implements DataStructure.Linked, TwoPointer.FastSlowPointer {
    public static void main(String[] args) {
        ListNode head = Kiligz.toListNode("1,2,3,3,2,1");
        Kiligz.print(new LCR027().isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = mid(head);
        ListNode reverseR = reverse(mid.next);
        while (reverseR != null) {
            if (head.val != reverseR.val) return false;
            head = head.next;
            reverseR = reverseR.next;
        }
        return true;
    }

    private ListNode mid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
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


    public boolean isPalindrome1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (!list.get(l++).equals(list.get(r--)))
                return false;
        }
        return true;
    }
}
