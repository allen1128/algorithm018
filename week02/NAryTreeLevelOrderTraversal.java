import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subres = new ArrayList<>();
            for (int i = 0 ; i < size; i++) {
                Node node = queue.poll();
                subres.add(node.val);
                for (int j = 0; j < node.children.size(); j++) {
                    queue.offer(node.children.get(j));
                }
            }
            result.add(subres);
        }
        return result;
    }
}
