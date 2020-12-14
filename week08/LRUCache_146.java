import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_146  extends LinkedHashMap<Integer, Integer>{

    private final int size;

    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.size() > size;
    }

    public LRUCache_146(int capacity) {
        super(capacity, 0.75f, true);
        this.size = capacity;
    }

    public int get(int key) {
        return getOrDefault(key, -1);
    }

}
