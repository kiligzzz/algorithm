package easy;

import support.Kiligz;
import type.Common;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 * 输入：s = "abaccdeff"
 * 输出：'b'
 *
 * @author Ivan
 * @since 2023/6/25
 */
public class Offer50 implements Common.Hash {
    public static void main(String[] args) {
        Kiligz.print(new Offer50().firstUniqChar("abaccdeff"));
    }

    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (char c : s.toCharArray())
            map.put(c, !map.containsKey(c));

        for (Map.Entry<Character, Boolean> entry : map.entrySet())
            if (entry.getValue()) return entry.getKey();

        return ' ';
    }
}
