package easy;

import support.Kiligz;
import type.DataStructure;

/**
 * 加一
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 *
 * @author Ivan
 * @since 2023/5/12
 */
public class N0066 implements DataStructure.Arrayed {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("1,2,3");
        Kiligz.print(new N0066().plusOne(arr));
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i] = ++digits[i] % 10;
            // 说明不需要进位，直接返回
            if (digits[i] != 0) return digits;
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
