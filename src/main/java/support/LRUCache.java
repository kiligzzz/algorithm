package support;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * LRU实现
 *
 * @author Ivan
 * @since 2024/3/25
 */
public class LRUCache {
    private final int capacity;
    private final Map<String, String> map = new HashMap<>();
    private final LinkedList<String> list = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public String get(String key) {
        if (map.containsKey(key)) {
            String value = map.get(key);
            list.remove(key);
            list.addFirst(key);
            return value;
        }
        return null;
    }

    public void put(String key, String value) {
        if (map.containsKey(key)) {
            list.remove(key);
        } else {
            if (map.size() >= capacity) {
                String k = list.removeLast();
                map.remove(k);
            }
        }
        list.addFirst(key);
        map.put(key, value);
    }
}
