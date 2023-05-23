package medium;

import support.Kiligz;
import type.Common;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * @author Ivan
 * @since 2023/4/17
 */
public class N0022 implements Common.Str {
    public static void main(String[] args) {
        Kiligz.print(new N0022().generateParenthesis(3));
    }

    StringBuilder sb = new StringBuilder();

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0);
        return res;
    }

    private void backtrack(int n, int lCount, int rCount) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }
        if (lCount < n) {
            sb.append('(');
            backtrack(n, lCount + 1, rCount);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rCount < lCount) {
            sb.append(')');
            backtrack(n, lCount, rCount + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
