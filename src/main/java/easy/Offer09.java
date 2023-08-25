package easy;

import type.DataStructure;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用两个栈实现队列
 *
 * @author Ivan
 * @since 2023/4/10
 */
public class Offer09 implements DataStructure.Queued {
    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }

    static class CQueue {
        Deque<Integer> in;
        Deque<Integer> out;

        public CQueue() {
            in = new ArrayDeque<>();
            out = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            in.push(value);
        }

        public int deleteHead() {
            if (out.isEmpty()) {
                if (in.isEmpty())
                    return -1;

                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }
    }
}
