package easy;

import support.Kiligz;
import type.Common;

/**
 * 二进制加法
 * 输入: a = "11", b = "10"
 * 输出: "101"
 *
 * @author Ivan
 * @since 2023/7/6
 */
public class OfferII002 implements Common.Number {
    public static void main(String[] args) {
        Kiligz.print(new OfferII002().addBinary("1", "111"));
    }

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int al = a.length();
        int bl = b.length();
        int l = Math.max(al, bl);
        int carry = 0;
        for (int i = 0; i < l; i++) {
            carry += i < al ? a.charAt(al - 1 - i) - '0' : 0;
            carry += i < bl ? b.charAt(bl - 1 - i) - '0' : 0;
            res.append(carry % 2);
            carry /= 2;
        }
        if (carry > 0) res.append('1');
        return res.reverse().toString();
    }
}
