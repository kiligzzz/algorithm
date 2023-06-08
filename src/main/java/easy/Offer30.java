package easy;

import support.Kiligz;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * @author Ivan
 * @since 2023/6/7
 */
public class Offer30 {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(2);
        obj.pop();
        Kiligz.print(obj.top());
        Kiligz.print(obj.min());
    }

    static class MinStack {
        Stack<Integer> stack, minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
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
