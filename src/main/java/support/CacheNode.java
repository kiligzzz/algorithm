package support;

public class CacheNode {
    public int key;
    public int value;
    public CacheNode pre;
    public CacheNode next;

    public CacheNode() {
    }

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}