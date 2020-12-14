import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] x, int[] y) {
                return x[0] - y[0];
            }
        });

        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                int maxRight = Math.max(result.get(result.size() - 1)[1], interval[1]);
                result.get(result.size() - 1)[1] = maxRight;
            }
        }

        return result.toArray(new int[result.size()][]);

    }
}
