package medium;

import support.Kiligz;
import type.Common;

/**
 * 求1+2+...+n
 * 输入: n = 3
 * 输出: 6
 * 不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 *
 * @author Ivan
 * @since 2023/7/4
 */
public class Offer64 implements Common.Number {
    public static void main(String[] args) {
        Kiligz.print(new Offer64().sumNums(3));
    }

    /**
     * 逻辑运算符短路效应
     * &&前的判断不满足，则后面的不会再执行
     */
    public int sumNums(int n) {
        boolean temp = n >= 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    /**
     * Math api
     * n (n + 1) / 2 -> (n^2 + n) >> 1
     */
    public int sumNums1(int n) {
        return (int) (Math.pow(n, 2) + n) >> 1;
    }
}
