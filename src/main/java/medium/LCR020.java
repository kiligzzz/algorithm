package medium;

import support.Kiligz;
import type.TwoPointer;

/**
 * 回文子串
 * 输入：s = "aaa"
 * 输出：6
 * 包含的回文子串个数
 *
 * @author Ivan
 * @since 2023/8/7
 */
public class LCR020 implements TwoPointer.CenterDiffuse {
    public static void main(String[] args) {
        Kiligz.print(new LCR020().countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += centerDiffuse(s, i, i);
            res += centerDiffuse(s, i, i + 1);
        }
        return res;
    }

    private int centerDiffuse(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }

    /**
     * TODO study Manacher算法
     */
    public int countSubstrings1(String s) {
        int n = s.length();
        StringBuilder t = new StringBuilder("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // 中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;
        }

        return ans;
    }

}
