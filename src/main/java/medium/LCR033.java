package medium;

import support.Kiligz;
import type.Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字母异位词分组
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * @author Ivan
 * @since 2023/8/17
 */
public class LCR033 implements Common.Str {
    public static void main(String[] args) {
        String[] strs = Kiligz.toArray("eat", "tea", "tan", "ate", "nat", "bat");
        Kiligz.print(new LCR033().groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(
                Arrays.stream(strs)
                        .collect(Collectors.groupingBy(str -> {
                            char[] chars = str.toCharArray();
                            Arrays.sort(chars);
                            return new String(chars);
                        }))
                        .values());
    }
}
