package medium;

import support.Kiligz;
import type.CSF;
import type.DFS;
import type.Recursive;

import java.util.*;

/**
 * 字符串的排列
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * 有重不可复用，不能有重复结果
 *
 * @author Ivan
 * @since 2023/6/14
 */
public class Offer38 implements CSF.FullPermutation, DFS.Backtrack, Recursive {
    public static void main(String[] args) {
        Kiligz.print(new Offer38().permutation("aba"));
    }

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean[] used;

    public String[] permutation(String s) {
        used = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        backtrack(chars);
        return res.toArray(new String[]{});
    }

    private void backtrack(char[] chars) {
        if (sb.length() == chars.length) {
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;
            if (i > 0 && chars[i] == chars[i - 1] && used[i - 1])
                continue;

            used[i] = true;
            sb.append(chars[i]);
            backtrack(chars);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}
