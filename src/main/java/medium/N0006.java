package medium;

import support.Kiligz;
import type.DataStructure;

/**
 * N字形变换
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 输入：s = "PAYPALISHIRING", numRows = 3 输出："PAHNAPLSIIGYIR"
 *
 * @author Ivan
 * @since 2023/2/28
 */
public class N0006 implements DataStructure.Arrayed {

    public static void main(String[] args) {
        Kiligz.print(new N0006().convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;

        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        int flag = -1;
        int cur = 0;
        for (char c : s.toCharArray()) {
            sbs[cur].append(c);
            if (cur == 0 || cur == numRows - 1) {
                flag = -flag;
            }
            cur += flag;
        }
        return String.join("", sbs);
    }
}
