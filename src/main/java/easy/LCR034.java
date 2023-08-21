package easy;

import support.Kiligz;
import type.Common;

/**
 * 验证外星语词典
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 *
 * @author Ivan
 * @since 2023/8/21
 */
public class LCR034 implements Common.Str {
    public static void main(String[] args) {
        String[] words = Kiligz.toArray("hello", "leetcode");
        Kiligz.print(new LCR034().isAlienSorted(words, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    static int[] arr = new int[26];

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            arr[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (isInvalid(words[i - 1], words[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isInvalid(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int lenMin = Math.min(len1, len2);
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int k = 0;
        while (k < lenMin) {
            int idx1 = arr[chars1[k] - 'a'];
            int idx2 = arr[chars2[k] - 'a'];
            if (idx1 != idx2) {
                return idx1 > idx2;
            }
            k++;
        }
        // 前缀相同，长的在前面无效
        return len1 > len2;
    }
}
