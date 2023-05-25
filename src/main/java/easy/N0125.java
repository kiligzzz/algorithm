package easy;

import support.Kiligz;
import type.TwoPointer;

/**
 * 验证回文串
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 *
 * @author Ivan
 * @since 2023/5/24
 */
public class N0125 implements TwoPointer {
    public static void main(String[] args) {
        Kiligz.print(new N0125().isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && isNotValid(s.charAt(i)))
                i++;
            while (i < j && isNotValid(s.charAt(j)))
                j--;

            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNotValid(char c) {
        return (c < 'a' || c > 'z') && (c < '0' || c > '9');
    }
}
