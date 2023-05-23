package easy;

import support.Kiligz;
import type.DataStructure;

/**
 * 旋转数组的最小数字
 * 输入：numbers = [3,4,5,1,2]
 * 输出：1
 *
 * @author Ivan
 * @since 2023/4/10
 */
public class Offer11 implements DataStructure.Arrayed {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("3,4,5,1,2");
        Kiligz.print(new Offer11().minArray(arr));
    }

    public int minArray(int[] numbers) {
        int min = numbers[0];
        for (int number : numbers) {
            if (number < min) {
                min = number;
                break;
            }
        }
        return min;
    }
}
