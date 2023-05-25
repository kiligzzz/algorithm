package medium;

import support.Kiligz;
import type.DynamicProgramming;
import type.TwoPointer;

import java.util.List;

/**
 * 单词拆分
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 *
 * @author Ivan
 * @since 2023/5/25
 */
public class N0139 implements DynamicProgramming, TwoPointer.FastSlowPointer {
    public static void main(String[] args) {
        List<String> list = Kiligz.toList("leet", "code");
        Kiligz.print(new N0139().wordBreak("leetcode", list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // 记录该索引之前的字符串是否可以由字典组合而成
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int r = 1; r < n + 1; r++) {
            for (int l = 0; l < r; l++) {
                if (dp[l] && wordDict.contains(s.substring(l, r))) {
                    dp[r] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
