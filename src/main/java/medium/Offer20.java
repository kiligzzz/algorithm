package medium;

import support.Kiligz;
import type.FSM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 表示数值的字符串
 * 输入：s = "-1E-16"
 * 输出：true
 *
 * 数值（按顺序）可以分成以下几个部分：
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 *
 * 小数（按顺序）可以分成以下几个部分：
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 *
 * 整数（按顺序）可以分成以下几个部分：
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 *
 * @author Ivan
 * @since 2023/6/2
 */
public class Offer20 implements FSM {
    public static void main(String[] args) {
        Kiligz.print(new Offer20().isNumber(" -1E-16"));
    }

    public boolean isNumber(String s) {
        List<Map<Character, Integer>> stateMapList = new ArrayList<>();
        stateMapList.add(new HashMap<Character, Integer>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }});
        stateMapList.add(new HashMap<Character, Integer>() {{ put('d', 2); put('.', 4); }});
        stateMapList.add(new HashMap<Character, Integer>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }});
        stateMapList.add(new HashMap<Character, Integer>() {{ put('d', 3); put('e', 5); put(' ', 8); }});
        stateMapList.add(new HashMap<Character, Integer>() {{ put('d', 3); }});
        stateMapList.add(new HashMap<Character, Integer>() {{ put('s', 6); put('d', 7); }});
        stateMapList.add(new HashMap<Character, Integer>() {{ put('d', 7); }});
        stateMapList.add(new HashMap<Character, Integer>() {{ put('d', 7); put(' ', 8); }});
        stateMapList.add(new HashMap<Character, Integer>() {{ put(' ', 8); }});

        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == 'e' || c == 'E') t = 'e';
            else if(c == '.' || c == ' ') t = c;
            else t = '?';
            if(!stateMapList.get(p).containsKey(t)) return false;
            p = stateMapList.get(p).get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }
}