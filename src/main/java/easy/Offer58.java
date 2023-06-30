package easy;

import support.Kiligz;
import type.Common;

import java.util.StringJoiner;

/**
 * 翻转单词顺序 & 左旋转字符串
 *
 * 输入: "  the sky   is blue"
 * 输出: "blue is sky the"
 * 去除前后、多余空格
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 左旋n位
 *
 * @author Ivan
 * @since 2023/6/30
 */
public class Offer58 implements Common.Str {
    public static void main(String[] args) {
//        Kiligz.print(new Offer58().reverseWords("  the sky   is blue"));

        Kiligz.print(new Offer58().reverseLeftWords("abcdefg", 2));
    }

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringJoiner res = new StringJoiner(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].isEmpty()) {
                res.add(arr[i]);
            }
        }
        return res.toString();
    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
