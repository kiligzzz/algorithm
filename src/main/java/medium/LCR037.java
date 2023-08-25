package medium;

import support.Kiligz;
import type.DataStructure;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 行星碰撞
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 相同方向不会碰撞，碰撞小的消失，相同则都消失
 *
 * @author Ivan
 * @since 2023/8/23
 */
public class LCR037 implements DataStructure.Stacked {
    public static void main(String[] args) {
        int[] asteroids = Kiligz.toIntArray("10,2,-5");
        Kiligz.print(new LCR037().asteroidCollision(asteroids));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            boolean isAlive = true;
            while (isAlive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                isAlive = stack.peek() < -asteroid;
                if (stack.peek() <= -asteroid) {
                    stack.pop();
                }
            }
            if (isAlive) {
                stack.push(asteroid);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
