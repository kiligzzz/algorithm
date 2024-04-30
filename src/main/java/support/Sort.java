package support;

import java.util.Arrays;

/**
 * 常见排序算法
 *
 * @author Ivan
 * @since 2024/3/27
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,6,4,7,3,5,9,8,2,0};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
