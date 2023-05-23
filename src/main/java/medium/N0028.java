package medium;

import support.Kiligz;
import type.TwoPointer;
import type.Violent;

/**
 * 找出字符串中第一个匹配项的下标
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 *
 * @author Ivan
 * @since 2023/4/17
 */
public class N0028 implements Violent, TwoPointer.KMP {
    public static void main(String[] args) {
        Kiligz.print(new N0028().strStr2("sadbutsad", "dbu"));
    }

    /**
     * 暴力
     */
    public int strStr1(String haystack, String needle) {
        char[] hcs = haystack.toCharArray();
        char[] ncs = needle.toCharArray();

        int hl = hcs.length;
        int nl = ncs.length;

        int l = hl - nl;
        for (int i = 0; i <= l; i++) {

            int h = i;
            int n = 0;
            while (n < nl && hcs[h] == ncs[n]) {
                h++;
                n++;
            }
            if (n == nl) return i;
        }
        return -1;
    }

    /**
     * KMP算法，快速查找匹配
     */
    public int strStr2(String s, String p) {
        int[] next = new int[p.length()];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < p.length() - 1) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        int m = 0, n = 0;
        while (m < s.length() && n < p.length()) {
            if (n == -1 || s.charAt(m) == p.charAt(n)) {
                m++;
                n++;
            } else {
                n = next[n];
            }
        }
        return n == p.length() ? m - n : -1;
    }
}
