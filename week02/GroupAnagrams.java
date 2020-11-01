import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    //time complexity: NKLogK
    //space complexity: NK
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            List<String> val = map.getOrDefault(sorted, new ArrayList<>());
            val.add(str);
            map.put(sorted, val);
        }
        return new ArrayList<>(map.values());
    }

    //Time complexity: NK
    //space complexity: NK
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] counts = new int[26];
        for (String str : strs) {
            Arrays.fill(counts, 0);
            for (char c : str.toCharArray()) {
                counts[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(counts[i]).append("#");
            }
            List<String> val = map.getOrDefault(sb.toString(), new ArrayList<>());
            val.add(str);
            map.put(sb.toString(), val);
        }
        return new ArrayList<>(map.values());
    }
}
