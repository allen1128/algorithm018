import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> lresult = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, visited, lresult);
        return result;
    }

    public void helper(int[] nums, boolean[] visited, List<Integer> lresult) {
        if (lresult.size() == nums.length) {
            result.add(new ArrayList<>(lresult));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            lresult.add(nums[i]);
            helper(nums, visited, lresult);
            lresult.remove(lresult.size() - 1);
            visited[i] = false;
        }
    }
}
