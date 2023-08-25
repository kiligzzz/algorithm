package easy;

import support.Kiligz;
import type.DataStructure;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 包含min函数的栈
 *
 * @author Ivan
 * @since 2023/6/7
 */
public class Offer30 implements DataStructure.Stacked {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(2);
        obj.pop();
        Kiligz.print(obj.top());
        Kiligz.print(obj.min());
    }

    static class MinStack {
        Deque<Integer> stack, minStack;

        public MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

}
