import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), root, 0, targetSum);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> current, TreeNode root, int sum, int k) {
        if (root == null) return;
        int size = current.size();
        current.add(root.val);
        if (root.left == null && root.right == null && sum + root.val == k) result.add(new ArrayList<>(current));
        dfs(result, current, root.left, sum + root.val, k);
        dfs(result, current, root.right, sum + root.val, k);
        current.remove(size);
    }
}
