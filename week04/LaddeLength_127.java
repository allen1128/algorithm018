import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class LaddeLength_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length() || !wordList.contains(endWord)) {
            return 0;
        }

        int length = 0;
        Set<String> set = wordList.stream().collect(Collectors.toSet());

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (queue.size() > 0 && set.size() > 0) {
            length++;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String w = queue.poll();
                for (int i = 0; i < w.length(); i++){
                    StringBuilder sb = new StringBuilder(w);
                    for (int y = 'a'; y <= 'z'; y++) {
                        if (w.charAt(i) == (char) y) {
                            continue;
                        } else {
                            sb.setCharAt(i, (char) y);
                            String newWord = sb.toString();
                            if (set.contains(newWord)) {
                                if (endWord.equals(newWord)) {
                                    return length + 1;
                                }

                                queue.add(newWord);
                                set.remove(newWord);
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }
}
