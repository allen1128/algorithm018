import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermuteUnique_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int c = map.getOrDefault(n, 0);
            map.put(n, c+1);
        }
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(map, 0, nums, path, result);
        return result;
    }

    public void helper(Map<Integer, Integer> map, int level, int[] nums, List<Integer> path, List<List<Integer>> result) {
        if (level == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i : map.keySet()) {
            if (map.get(i) == 0) {
                continue;
            }
            map.put(i, map.get(i)-1);
            path.add(i);
            helper(map, level + 1, nums, path, result);
            map.put(i, map.get(i)+1);
            path.remove(path.size() - 1);
        }
    }
}
