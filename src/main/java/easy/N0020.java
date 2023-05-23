package easy;

import support.Kiligz;
import type.DataStructure;

import java.util.Stack;

/**
 * 有效的括号
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * @author Ivan
 * @since 2023/4/16
 */
public class N0020 implements DataStructure.Stacked {
    public static void main(String[] args) {
        Kiligz.print(new N0020().isValid("["));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.add(')');
            } else if (c == '[') {
                stack.add(']');
            } else if (c == '{') {
                stack.add('}');
            } else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
