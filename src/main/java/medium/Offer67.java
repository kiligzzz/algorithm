package medium;

import support.Kiligz;
import type.Common;

/**
 * 把字符串转换成整数
 * 输入: " -42"
 * 输出: -42
 *
 * @author Ivan
 * @since 2023/7/5
 */
public class Offer67 implements Common.Str {
    public static void main(String[] args) {
        Kiligz.print(new Offer67().strToInt(" -42"));
    }

    public int strToInt(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;

        int cur = 0;
        boolean isStart = false;
        boolean positive = true;
        for (char c : str.toCharArray()) {
            if (c < '0' || c > '9') {
                if (isStart || (c != '+' && c != '-')) break;
                if (c == '-') positive = false;
            } else {
                int num = c - '0';
                if (positive) {
                    if (cur > (Integer.MAX_VALUE - num) / 10) return Integer.MAX_VALUE;
                    cur = cur * 10 + num;
                } else {
                    if (cur < (Integer.MIN_VALUE + num) / 10) return Integer.MIN_VALUE;
                    cur = cur * 10 - num;
                }
            }
            isStart = true;
        }
        return cur;
    }
}
