package medium;

import support.Kiligz;
import type.Common;

import java.util.*;

/**
 * O(1)时间插入、删除和获取随机元素
 * 输出：[null,true,true,true,true,true,2]
 *
 * @author Ivan
 * @since 2023/8/15
 */
public class LCR030 implements Common.Hash {
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        Kiligz.print(obj.insert(0));
        Kiligz.print(obj.insert(1));
        Kiligz.print(obj.remove(0));
        Kiligz.print(obj.insert(2));
        Kiligz.print(obj.remove(1));
        Kiligz.print(obj.getRandom());
    }

    static class RandomizedSet {

        List<Integer> list;
        Map<Integer, Integer> map;
        Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val))
                return false;

            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val))
                return false;

            int removeIdx = map.remove(val);
            int lastIdx = list.size() - 1;

            int last = list.remove(lastIdx);
            if (removeIdx != lastIdx) {
                list.set(removeIdx, last);
                map.put(last, removeIdx);
            }
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
