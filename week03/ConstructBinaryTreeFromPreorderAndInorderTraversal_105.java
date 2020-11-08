import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    Map<Integer, Integer> map = new HashMap<>(0);

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode node = helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return node;
    }

    public TreeNode helper(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight) {
            return null;
        }
        int preorderRoot = preorderLeft;
        int inorderRootIndex = map.get(preorder[preorderRoot]);
        int leftTreeSize = inorderRootIndex - inorderLeft;
        TreeNode treeNode = new TreeNode(preorder[preorderRoot]);
        treeNode.left = helper(preorder, inorder, preorderLeft + 1, preorderLeft + leftTreeSize, inorderLeft, inorderRootIndex - 1);
        treeNode.right = helper(preorder, inorder, preorderLeft + leftTreeSize + 1, preorderRight, inorderRootIndex + 1, inorderRight);
        return treeNode;
    }
}
