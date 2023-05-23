package type;

/**
 * 双指针
 *
 * @author Ivan
 * @date 2023/2/28 16:34
 */
@SuppressWarnings("all")
public interface TwoPointer {
    /**
     * 二分
     */
    interface Binary extends TwoPointer {
    }

    /**
     * 滑动窗口
     */
    interface SlideWindow extends TwoPointer {
    }

    /**
     * 中心扩散
     */
    interface CenterDiffuse extends TwoPointer {
    }

    /**
     * 快慢指针
     */
    interface FastSlowPointer extends TwoPointer {
    }

    /**
     * 快速查找匹配
     */
    interface KMP {
        /**
         * 主  串：A B A B A C
         * 模式串：A B A C
         * next[-1,0,0,1]
         *
         * next数组
         *  - 前缀子串：不包含最后一个字符的子串集，对于C位置，{A,AB}
         *  - 后缀子串：不包含第一个字符的子串集，对于C位置，{A,BA}
         *  - 下标：该字符前子串的长度
         *  - 值：该字符前面前后缀子串最大公共子串的长度（也就是将来匹配失败后，模式串向后移动的下标）
         *      - 如：此时'C'与'B'匹配失败，模式串向后移动到模式串下标为1的位置
         *      - [ABA'B'AC] -> [ABA'B'AC]
         *      - [ABA'C']        [A'B'AC]
         */
        default int[] getNext(String p) {
            int[] next = new int[p.length()];
            next[0] = -1;
            int i = 0, j = -1;
            while (i < p.length() - 1) {
                if (j == -1 || p.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                    next[i] = j;
                } else {
                    j = next[j];
                }
            }
            return next;
        }

        /**
         * KMP匹配
         */
        default int getMatchStart(int[] next, String s, String p) {
            int m = 0, n = 0;
            while (m < s.length() && n < p.length()) {
                if (n == -1 || s.charAt(m) == p.charAt(n)) {
                    m++;
                    n++;
                } else {
                    n = next[n];
                }
            }
            return n == p.length() ? m - n : -1;
        }
    }
}
