package medium;

import support.Kiligz;
import type.TwoPointer;

import java.util.Arrays;

/**
 * 字符串中的变位词
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: true
 *
 * @author Ivan
 * @since 2023/8/2
 */
public class LCR014 implements TwoPointer.SlideWindow {
    public static void main(String[] args) {
        Kiligz.print(new LCR014().checkInclusion("ab", "eidbaooo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 > len2) return false;

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < len1; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2)) return true;

        for (int i = len1; i < len2; i++) {
            cnt2[s2.charAt(i - len1) - 'a']--;
            cnt2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(cnt1, cnt2)) return true;
        }
        return false;
    }
}
