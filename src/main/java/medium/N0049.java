package medium;

import support.Kiligz;
import type.Common;
import type.DataStructure;

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
 * @since 2023/5/6
 */
public class N0049 implements Common.Str, DataStructure.Arrayed {
    public static void main(String[] args) {
        String[] strs = Kiligz.toArray("eat", "tea", "tan", "ate", "nat", "bat");
        Kiligz.print(new N0049().groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(
                Arrays.stream(strs)
                        .collect(Collectors.groupingBy(str -> {
                            char[] chars = str.toCharArray();
                            Arrays.sort(chars);
                            return new String(chars);
                        }))
                        .values()
        );
    }
}
