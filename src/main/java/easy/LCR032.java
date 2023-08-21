package easy;

import support.Kiligz;
import type.Common;

import java.util.Arrays;

/**
 * 有效的字母异位词
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 字符个数相同，顺序不同
 *
 * @author Ivan
 * @since 2023/8/17
 */
public class LCR032 implements Common.Hash {
    public static void main(String[] args) {
        Kiligz.print(new LCR032().isAnagram("anagram", "nagaram"));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t))
            return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int idx = t.charAt(i) - 'a';
            count[idx]--;

            if (count[idx] < 0) return false;
        }
        return true;
    }
}
