public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode root, Integer l, Integer r) {
        if (root == null) return true;
        if ((l != null && root.val <= l) || (r != null && root.val >= r)) return false;
        if (!dfs(root.left, l, root.val)) return false;
        if (!dfs(root.right, root.val, r)) return false;
        return true;
    }
}
