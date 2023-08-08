package medium;

import support.Kiligz;
import type.DynamicProgramming;
import type.TwoPointer;

/**
 * 最长回文子串
 * 输入：s = "babad" 输出："bab"
 *
 * @author Ivan
 * @since 2023/2/27
 */
public class N0005 implements TwoPointer.CenterDiffuse {
    public static void main(String[] args) {
        Kiligz.print(new N0005().longestPalindrome("cbbd"));
    }

    /**
     * 中心扩散
     */
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = centerDiffuse(s, i, i);
            int len2 = centerDiffuse(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int centerDiffuse(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
