package medium;

import support.CacheNode;
import support.Kiligz;
import type.DataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存
 * 输出：[null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * @author Ivan
 * @since 2023/8/15
 */
public class LCR031 implements DataStructure.Linked {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        Kiligz.print(lRUCache.get(1));
        lRUCache.put(3, 3);
        Kiligz.print(lRUCache.get(2));
        lRUCache.put(4, 4);
        Kiligz.print(lRUCache.get(1));
        Kiligz.print(lRUCache.get(3));
        Kiligz.print(lRUCache.get(4));
    }

    static class LRUCache {
        Map<Integer, CacheNode> cache;
        int capacity, size;
        CacheNode head, tail;


        public LRUCache(int capacity) {
            cache = new HashMap<>();
            this.capacity = capacity;
            head = new CacheNode();
            tail = new CacheNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            CacheNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            CacheNode node = cache.get(key);
            if (node == null) {
                node = new CacheNode(key, value);
                cache.put(key, node);
                addToHead(node);
                size++;
                if (size > capacity) {
                    size--;
                    cache.remove(tail.pre.key);
                    removeTail();
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        private void moveToHead(CacheNode node) {
            removeNode(node);
            addToHead(node);
        }

        private void removeTail() {
            removeNode(tail.pre);
        }

        private void removeNode(CacheNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private void addToHead(CacheNode node) {
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }
    }
}
