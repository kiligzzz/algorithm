package easy;

import support.Kiligz;
import type.Common;

/**
 * 回文数
 * 输入：x = 121 输出：true
 *
 * @author Ivan
 * @since 2023/2/28
 */
public class N0009 implements Common.Number {
    public static void main(String[] args) {
        Kiligz.print(new N0009().isPalindrome(-121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int num = x;
        int res = 0;
        while (num != 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res == x;
    }
}
