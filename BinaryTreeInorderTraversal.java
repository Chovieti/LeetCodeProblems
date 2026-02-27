import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursiveDfs(root, result);
        return result;
    }

    private void recursiveDfs(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        if (root.left != null) recursiveDfs(root.left, list);
        list.add(root.val);
        if (root.right != null) recursiveDfs(root.right, list);
    }
}
