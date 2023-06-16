package easy;

import support.Kiligz;
import type.Binary;
import type.DataStructure;
import type.Sort;

import java.util.Arrays;

/**
 * 最小的k个数
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * @author Ivan
 * @since 2023/6/16
 */
public class Offer40 implements DataStructure.Arrayed, Sort.QuickSort {
    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("0,0,2,3,2,1,1,2,0,4");
        Kiligz.print(new Offer40().getLeastNumbers1(arr, 10));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    public int[] getLeastNumbers1(int[] arr, int k) {
        if (arr.length <= k) return arr;
        return quickSort(arr, k, 0, arr.length - 1);
    }

    public int[] quickSort(int[] arr, int k, int left, int right) {
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && arr[r] >= arr[left]) r--;
            while (l < r && arr[l] <= arr[left]) l++;

            if (l < r) {
                swap(arr, l, r);
            }
        }
        swap(arr, l, left);

        if (l > k) return quickSort(arr, k, left, l - 1);
        if (l < k) return quickSort(arr, k, l + 1, right);
        return Arrays.copyOf(arr, k);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
