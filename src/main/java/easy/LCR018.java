package easy;

import support.Kiligz;
import type.TwoPointer;

/**
 * 验证回文串
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * @author Ivan
 * @since 2023/8/4
 */
public class LCR018 implements TwoPointer {
    public static void main(String[] args) {
        Kiligz.print(new LCR018().isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && isNotValid(s.charAt(l)))
                l++;

            while (l < r && isNotValid(s.charAt(r)))
                r--;

            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }

    private boolean isNotValid(char c) {
        return (c < 'a' || c > 'z') && (c < '0' || c > '9');
    }
}
