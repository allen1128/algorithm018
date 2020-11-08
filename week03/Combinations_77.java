import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0) {
            return result;
        }
        helper(1, n, k, new ArrayList<>());
        return result;
    }

    public void helper(int curr, int n, int k, List<Integer> path) {
        if (path.size() + (n - curr + 1) < k) {
            return;
        }
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        path.add(curr);
        helper(curr + 1, n, k, path);
        path.remove(path.size() - 1);
        helper(curr + 1, n, k, path);
    }
}
