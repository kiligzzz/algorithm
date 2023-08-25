package medium;

import support.Kiligz;
import type.DataStructure;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 每日温度
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * @author Ivan
 * @since 2023/8/25
 */
public class LCR038 implements DataStructure.Stacked {
    public static void main(String[] args) {
        int[] temperatures = Kiligz.toIntArray("73,74,75,71,69,72,76,73");
        Kiligz.print(new LCR038().dailyTemperatures(temperatures));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int preIdx = stack.pop();
                res[preIdx] = i - preIdx;
            }
            stack.push(i);
        }
        return res;
    }
}
