package support;

/**
 * 基础算法
 *
 * @author Ivan
 * @since 2023/4/3
 */
public class BasicUtil {
    /**
     * 二分查找（需有序状态）
     */
    public static int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int mid;
        while (l < r) {
            mid = (l + r) / 2;
            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target)
                l = mid;
            else
                r = mid;
        }
        return -1;
    }
}
