package easy;

import support.Kiligz;
import type.DynamicProgramming;

/**
 * 圆圈中最后剩下的数字
 * 输入: n = 5, m = 3
 * 输出: 3
 *
 * @author Ivan
 * @since 2023/7/3
 */
public class Offer62 implements DynamicProgramming {
    public static void main(String[] args) {
        Kiligz.print(new Offer62().lastRemaining(5, 3));
    }

    /**
     * n,m：数字环为 0,1,2,...,n−1 ，解为 f(n) ；
     * n−1,m：数字环为 0,1,2,...,n−2 ，解为 f(n−1) ；
     * 删除的数字为 (m−1)%n ，删除后的数字环从下个数字（m%n）开始，设t=m%n，可得：
     *               t,t+1,t+2,...,0,1,...,t−3,t−2
     * 设一个数字x对比n-1,m可推出 x -> (x+t)%n -> (x+m%n)%n -> (x+m)%n
     * f(n) = (f(n−1) + m) % n
     */
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
}
