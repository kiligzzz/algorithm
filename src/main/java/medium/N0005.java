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
public class N0005 implements TwoPointer.CenterDiffuse, DynamicProgramming {
    public static void main(String[] args) {
        Kiligz.print(new N0005().longestPalindrome2("cbbd"));
    }

    /**
     * 中心扩散
     */
    public String longestPalindrome1(String s) {
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

    /**
     * 动态规划,dp[l][r] = dp[l + 1][r - 1] && f(l, r);
     */
    public String longestPalindrome2(String s) {
        int length = s.length();
        if (length < 2) return s;

        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 1;
        boolean[][] dp = new boolean[length][length];

        for (int r = 1; r < length; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r)
                        && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    int len = r - l + 1;
                    if (len > maxLen) {
                        maxStart = l;
                        maxEnd = r;
                        maxLen = len;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    public int centerDiffuse(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
