package medium;

import support.Kiligz;
import type.Common;

import java.util.Comparator;
import java.util.List;

/**
 * 最小时间差
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 *
 * @author Ivan
 * @since 2023/8/21
 */
public class LCR035 implements Common.Str {
    public static void main(String[] args) {
        List<String> timePoints = Kiligz.toList("23:59", "00:00");
        Kiligz.print(new LCR035().findMinDifference(timePoints));
    }

    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        // 一共有个时间点，超过则必定有相同的
        if (size > 1440) return 0;

        timePoints.sort(Comparator.naturalOrder());
        int min = Integer.MAX_VALUE;
        int first = 0;
        int last = 0;
        for (int i = 0; i < size - 1; i++) {
            int cur = getMinutes(timePoints.get(i));
            int next = getMinutes(timePoints.get(i + 1));
            min = Math.min(min, next - cur);
            if (i == 0) first = cur;
            if (i == size - 2) last = next;
        }
        min = Math.min(min, first + 1440 - last);
        return min;
    }

    private int getMinutes(String str) {
        return ((str.charAt(0) - '0') * 10 + str.charAt(1) - '0') * 60
                + (str.charAt(3) - '0') * 10 + str.charAt(4) - '0';
    }
}
