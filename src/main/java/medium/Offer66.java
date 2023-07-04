package medium;

import support.Kiligz;
import type.DynamicProgramming;

/**
 * 构建乘积数组
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 * 返回数组值是输入数组中除了下标i以外的元素的积
 *
 * @author Ivan
 * @since 2023/7/4
 */
public class Offer66 implements DynamicProgramming {
    public static void main(String[] args) {
        int[] a = Kiligz.toIntArray("1,2,3,4,5");
        Kiligz.print(new Offer66().constructArr(a));
    }

    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0) return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        // 当前元素左边所有元素的乘积
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        // 当前元素左边所有元素的乘积 * 右边所有元素的乘积
        int right = 1;
        for (int i = len - 2; i >= 0; i--) {
            right *= a[i + 1];
            b[i] *= right;
        }
        return b;
    }
}
