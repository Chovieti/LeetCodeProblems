public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode root, int sum, int k) {
        if (root == null) return false;
        sum += root.val;
        if (root.left == null && root.right == null) return sum == k;
        return dfs(root.left, sum, k) || dfs(root.right, sum, k);
    }
}
