package easy;

import support.Kiligz;
import type.DataStructure;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 数据流中的移动平均值
 * 输入：3，1、10、3、5
 * 输出：[null, 1.0, 5.5, 4.66667, 6.0]
 *
 * @author Ivan
 * @since 2023/8/25
 */
public class LCR041 implements DataStructure.Queued {
    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        Kiligz.print(movingAverage.next(1));
        Kiligz.print(movingAverage.next(10));
        Kiligz.print(movingAverage.next(3));
        Kiligz.print(movingAverage.next(5));
    }

    static class MovingAverage {
        int capacity;
        double sum;
        Deque<Integer> deque;

        public MovingAverage(int size) {
            capacity = size;
            deque = new ArrayDeque<>();
        }

        public double next(int val) {
            sum += val;
            deque.addLast(val);
            if (deque.size() > capacity) {
                sum -= deque.removeFirst();
            }
            return sum / deque.size();
        }
    }
}
