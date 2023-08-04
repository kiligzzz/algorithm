package medium;

import support.Kiligz;
import type.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中的所有字母异位词
 * 返回开始索引位置，可无序
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 *
 * @author Ivan
 * @since 2023/8/4
 */
public class LCR015 implements TwoPointer.SlideWindow {
    public static void main(String[] args) {
        Kiligz.print(new LCR015().findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int lenS = s.length();
        int lenP = p.length();
        if (lenS < lenP) return res;

        int[] cntP = new int[26];
        int[] cntS = new int[26];
        for (int i = 0; i < lenP; i++) {
            cntS[s.charAt(i) - 'a']++;
            cntP[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cntS, cntP))
            res.add(0);

        for (int i = lenP; i < lenS; i++) {
            cntS[s.charAt(i - lenP) - 'a']--;
            cntS[s.charAt(i) - 'a']++;
            if (Arrays.equals(cntS, cntP))
                res.add(i - lenP + 1);
        }
        return res;
    }
}
