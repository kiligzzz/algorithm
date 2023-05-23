package easy;

import support.Kiligz;
import type.Common;

/**
 * 最长公共前缀
 * 输入：strs = ["flower","flow","flight"] 输出："fl"
 *
 * @author Ivan
 * @since 2023/3/1
 */
public class N0014 implements Common.Str {
    public static void main(String[] args) {
        String[] arr = Kiligz.toArray("flower", "flow", "flight");
        Kiligz.print(new N0014().longestCommonPrefix(arr));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length - 1; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
