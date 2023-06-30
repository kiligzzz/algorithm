package medium;

import support.Kiligz;
import type.DataStructure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列的最大值
 * MaxQueue maxQueue = new MaxQueue();
 * maxQueue.push_back(1);
 * maxQueue.push_back(2);
 * maxQueue.max_value();
 * maxQueue.pop_front();
 * maxQueue.max_value();
 *
 * @author Ivan
 * @since 2023/6/30
 */
public class Offer59 implements DataStructure.Queued {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.pop_front();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        Kiligz.print(maxQueue.max_value());;
        Kiligz.print(maxQueue.pop_front());;
        Kiligz.print(maxQueue.max_value());;
    }

    static class MaxQueue {
        Queue<Integer> queue;
        Deque<Integer> maxDeque;

        public MaxQueue() {
            queue = new LinkedList<>();
            maxDeque = new LinkedList<>();
        }

        public int max_value() {
            return maxDeque.isEmpty() ? -1 : maxDeque.peekFirst();
        }

        public void push_back(int value) {
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < value)
                maxDeque.pollLast();
            maxDeque.offerLast(value);
            queue.offer(value);
        }

        public int pop_front() {
            Integer value = queue.poll();
            if (value == null) return -1;

            if (value.equals(maxDeque.peekFirst()))
                maxDeque.pollFirst();
            return value;
        }
    }
}

