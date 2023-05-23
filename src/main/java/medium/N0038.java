package medium;

import support.Kiligz;
import type.DynamicProgramming;
import type.Recursive;
import type.TwoPointer;

/**
 * 外观数列
 * 输入：n = 4
 * 输出："1211"
 * 解释：
 * countAndSay(1) = "1"
 * countAndSay(2) = 读 "1" = 一 个 1 = "11"
 * countAndSay(3) = 读 "11" = 二 个 1 = "21"
 * countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
 *
 * @author Ivan
 * @since 2023/4/23
 */
public class N0038 implements TwoPointer.FastSlowPointer, Recursive, DynamicProgramming {
    public static void main(String[] args) {
        Kiligz.print(new N0038().countAndSay2(4));
    }

    StringBuilder res = new StringBuilder();

    /**
     * 执行耗时:1 ms,击败了96.09% 的Java用户
     * 内存消耗:38.8 MB,击败了95.82% 的Java用户
     */
    public String countAndSay1(int n) {
        if (n == 1) return "1";

        String pre = countAndSay1(n - 1);
        res.setLength(0);
        int l = 0;
        while (l < pre.length()) {
            int r = l + 1;
            // 循环直到两个指针所在位置结果不相等
            while (r < pre.length()
                    && pre.charAt(l) == pre.charAt(r)) {
                r++;
            }
            // 记录
            res.append(r - l).append(pre.charAt(l));
            l = r;
        }
        return res.toString();
    }

    public String countAndSay2(int n) {
        String[] dp = new String[n + 1];
        dp[1] = "1";
        for (int i = 2; i <= n; i++) {
            String pre = dp[i - 1];
            int l = 0;
            while (l < pre.length()) {
                int r = l + 1;
                // 循环直到两个指针所在位置结果不相等
                while (r < pre.length()
                        && pre.charAt(l) == pre.charAt(r)) {
                    r++;
                }
                // 记录
                res.append(r - l).append(pre.charAt(l));
                l = r;
            }
            dp[i] = res.toString();
            res.setLength(0);
        }
        return dp[n];
    }
}
