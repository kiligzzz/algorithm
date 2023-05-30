package medium;

import support.Kiligz;
import type.DFS;
import type.Recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * @author Ivan
 * @since 2023/4/10
 */
public class N0017 implements DFS.Backtrack, Recursive {
    public static void main(String[] args) {
        Kiligz.print(new N0017().letterCombinations("23"));
    }

    static final Map<Character, String> letterMap = new HashMap<Character, String>() {{
        put('0', "");
        put('1', "");
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> res = new ArrayList<>();

    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return res;
        backtrack(digits, 0);
        return res;
    }

    private void backtrack(String digits, int idx) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = letterMap.get(digits.charAt(idx));
        for (char c : letters.toCharArray()) {
            sb.append(c);
            backtrack(digits, idx + 1);
            sb.deleteCharAt(idx);
        }
    }
}
