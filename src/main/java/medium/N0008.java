package medium;

import support.Kiligz;
import type.Common;

/**
 * 字符串转换整数
 * 输入：s = " -42" 输出：-42
 *
 * @author Ivan
 * @since 2023/2/28
 */
public class N0008 implements Common.Str {

    public static void main(String[] args) {
        Kiligz.print(new N0008().myAtoi(" -42"));
    }

    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int cur = 0;
        boolean isStart = false;
        boolean positive = true;
        for (char c : s.toCharArray()) {
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
