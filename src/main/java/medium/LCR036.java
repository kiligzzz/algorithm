package medium;

import support.Kiligz;
import type.DataStructure;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 逆波兰表达式求值
 * 输入：tokens = ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"] 输出：6
 *
 * @author Ivan
 * @since 2023/8/22
 */
public class LCR036 implements DataStructure.Stacked {
    public static void main(String[] args) {
        String[] tokens = Kiligz.toArray("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+");
        Kiligz.print(new LCR036().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
