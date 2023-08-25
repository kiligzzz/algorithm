package medium;

import support.Kiligz;
import type.DataStructure;
import type.TwoPointer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 栈的压入、弹出序列
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 *
 * @author Ivan
 * @since 2023/6/8
 */
public class Offer31 implements DataStructure.Stacked, TwoPointer {
    public static void main(String[] args) {
        int[] pushed = Kiligz.toIntArray("1,2,3,4,5");
        int[] popped = Kiligz.toIntArray("4,5,3,2,1");
        Kiligz.print(new Offer31().validateStackSequences1(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int idx = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[idx]) {
                stack.pop();
                idx++;
            }
        }
        return idx == popped.length;
    }

    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        int pushI = 0;
        int popI = 0;
        for (int num : pushed) {
            pushed[pushI] = num;
            while (pushI >= 0 && pushed[pushI] == popped[popI]) {
                pushI--;
                popI++;
            }
            pushI++;
        }
        return popI == popped.length;
    }
}
