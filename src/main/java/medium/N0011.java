package medium;

import support.Kiligz;
import type.TwoPointer;

/**
 * 盛最多水的容器
 * 输入：[1,8,6,2,5,4,8,3,7] 输出：49
 *
 * @author Ivan
 * @since 2023/2/28
 */
public class N0011 implements TwoPointer {

    public static void main(String[] args) {
        int[] arr = Kiligz.toIntArray("1,8,6,2,5,4,8,3,7");
        Kiligz.print(new N0011().maxArea(arr));
    }

    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            max = height[l] < height[r] ?
                    Math.max(max, (r - l) * height[l++]) :
                    Math.max(max, (r - l) * height[r--]);
        }
        return max;
    }
}
