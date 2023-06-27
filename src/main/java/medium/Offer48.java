package medium;

import support.Kiligz;
import type.TwoPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 * 输入: "abcabcbb"
 * 输出: 3
 *
 * @author Ivan
 * @since 2023/6/21
 */
public class Offer48 implements TwoPointer.SlideWindow {
    public static void main(String[] args) {
        Kiligz.print(new Offer48().lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        int l = 0;
        int r = 1;
        int res = 0;
        while (r < s.length()) {
            int newL = 0;
            for (int i = l; i < r; i++) {
                if (s.charAt(i) == s.charAt(r)) {
                    newL = i + 1;
                    break;
                }
            }
            if (newL > 0) {
                l = newL;
            } else {
                res = Math.max(res, r - l + 1);
                r++;
            }
        }
        return res;
    }


    public int lengthOfLongestSubstring1(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        // 窗口开始位置
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i + 1 - left);
        }
        return max;
    }
}
