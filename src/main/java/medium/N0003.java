package medium;

import support.Kiligz;
import type.TwoPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复最长子串
 * 输入: s = "abcabcbb" 输出: 3
 *
 * @author Ivan
 * @since 2023/2/27
 */
public class N0003 implements TwoPointer.SlideWindow {

    public static void main(String[] args) {
        String str = "abcabcbb";
        Kiligz.print(new N0003().lengthOfLongestSubstring(str));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        // 窗口开始位置
        int left = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i + 1 - left);
        }
        return max;
    }
}
