package medium;

import support.Kiligz;
import type.TwoPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 输入: s = "abcabcbb"
 * 输出: 3
 *
 * @author Ivan
 * @since 2023/8/4
 */
public class LCR016 implements TwoPointer.SlideWindow {
    public static void main(String[] args) {
        Kiligz.print(new LCR016().lengthOfLongestSubstring(" "));
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                left = Math.max(left, map.get(c) + 1);

            res = Math.max(res, i - left + 1);
            map.put(c, i);
        }
        return res;
    }
}
