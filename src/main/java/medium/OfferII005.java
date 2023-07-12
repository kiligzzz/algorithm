package medium;

import support.Kiligz;
import type.Common;

import java.util.HashMap;
import java.util.Map;

/**
 * 单词长度的最大乘积
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 要求两个乘数不包含相同字符
 *
 * @author Ivan
 * @since 2023/7/10
 */
public class OfferII005 implements Common.Number {
    public static void main(String[] args) {
        String[] words = Kiligz.toArray("abcw", "baz", "foo", "bar", "fxyz", "abcdef");
        Kiligz.print(new OfferII005().maxProduct(words));
    }

    /**
     * 通过char字符对应的数字n，来左移n位，最后mem就存储了该字符串所有字符的是否存在的信息
     */
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String w : words) {
            int mem = 0;
            for (int i = 0; i < w.length(); i++) {
                int n = w.charAt(i) - 'a';
                mem |= (1 << n);
            }
            map.merge(mem, w.length(), Math::max);
        }
        int res = 0;
        for (int a : map.keySet()) {
            for (int b : map.keySet()) {
                if ((a & b) == 0)
                    res = Math.max(res, map.get(a) * map.get(b));
            }
        }
        return res;
    }

    public int maxProduct1(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isSame(words[i], words[j])) continue;
                res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        return res;
    }

    private boolean isSame(String a, String b) {
        for (char c : a.toCharArray()) {
            if (b.indexOf(c) >= 0) {
                return true;
            }
        }
        return false;
    }
}
