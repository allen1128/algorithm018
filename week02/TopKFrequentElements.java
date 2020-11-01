import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int freq = map.getOrDefault(num, 0);
            map.put(num, ++freq);
        }
        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for (Integer key : map.keySet()) {
            if (queue.size() == k) {
                if (queue.peek().getValue() < map.get(key)) {
                    queue.offer(new Pair(key, map.get(key)));
                    queue.poll();
                }
            } else {
                queue.offer(new Pair(key, map.get(key)));
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }
}
