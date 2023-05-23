package medium;

import support.Kiligz;
import type.DataStructure;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 合并区间
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 *
 * @author Ivan
 * @since 2023/5/10
 */
public class N0056 implements DataStructure.Arrayed {
    public static void main(String[] args) {
        int[][] arr = Kiligz.to2DIntArray("1,3",
                "2,6",
                "8,10",
                "15,18");
        Kiligz.print(new N0056().merge(arr));
    }

    public int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        int[][] res = new int[intervals.length][2];

        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || res[idx][1] < interval[0]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}
