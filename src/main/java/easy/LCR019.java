package easy;

import support.Kiligz;
import type.DynamicProgramming;
import type.TwoPointer;

/**
 * 验证回文串II
 * 输入: s = "abca"
 * 输出: true
 * 最多删除一个字符后，是否为回文串
 *
 * @author Ivan
 * @since 2023/8/7
 */
public class LCR019 implements DynamicProgramming.Greed, TwoPointer {
    public static void main(String[] args) {
        Kiligz.print(new LCR019().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return validPalindrome(s, l + 1, r) || validPalindrome(s, l, r - 1);
            }
        }
        return true;
    }

    private boolean validPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}
