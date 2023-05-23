package medium;

import support.Kiligz;
import type.Common;

/**
 * 字符串转换整数
 * 输入：s = " -42" 输出：-42
 *
 * @author Ivan
 * @since 2023/2/28
 */
public class N0008 implements Common.Str {

    public static void main(String[] args) {
        Kiligz.print(new N0008().myAtoi(" -42"));
    }

    public int myAtoi(String s) {
        // 去除两端空格
        s = s.trim();
        if(s.length() == 0) return 0;
        boolean hasNum = false;
        int cur = 0;
        boolean positive = true;
        for(char c : s.toCharArray()){
            if(c < '0' || c > '9'){
                // 只允许出现一次- +
                if(!hasNum && (c == '-' || c== '+')){
                    hasNum = true;
                    if(c == '-'){
                        // 确定符号位
                        positive = false;
                    }
                    continue;
                }
                break;
            }
            int toInt = c - '0';
            if(positive){
                // 防止溢出
                if(cur > (Integer.MAX_VALUE - toInt) / 10) return Integer.MAX_VALUE;
                cur = cur * 10 + toInt;
            }else{
                // 防止溢出
                if(cur < (Integer.MIN_VALUE + toInt) / 10) return Integer.MIN_VALUE;
                cur = cur * 10 - toInt;
            }
            hasNum = true;
        }
        return cur;
    }
}
