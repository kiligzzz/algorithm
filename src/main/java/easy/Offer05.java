package easy;

import support.Kiligz;
import type.Common;

/**
 * 替换空格
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * @author Ivan
 * @since 2023/4/3
 */
public class Offer05 implements Common.Str {
    public static void main(String[] args) {
        Kiligz.print(new Offer05().replaceSpace("We are happy."));
    }

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ')
                sb.append("%20");
            else
                sb.append(c);
        }
        return sb.toString();
    }
}
