package medium;

import support.Kiligz;
import type.Binary;
import type.Recursive;

/**
 * 数值的整数次方
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * @author Ivan
 * @since 2023/6/1
 */
public class Offer16 implements Recursive, Binary {
    public static void main(String[] args) {
        Kiligz.print(new Offer16().myPow(2.00000, 10));
    }

    /**
     * 快速幂
     */
    public double myPow(double x, int n) {
        return n >= 0 ?
                pow(x, n) : 1 / pow(x, -n);
    }

    public double pow(double x, int n) {
        if (n == 0) return 1;

        double v = pow(x, n / 2);
        return n % 2 == 0 ? v * v : v * v * x;
    }
}

