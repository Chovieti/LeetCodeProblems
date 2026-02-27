public class MaximumDepthOfBinaryTree {
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

    public int maxDepth(TreeNode root) {
        return recursiveDfs(root, 0);
    }

    private int recursiveDfs(TreeNode root, int currentDepth) {
        int maxDepth = currentDepth;
        if (root == null) return maxDepth;
        maxDepth = Math.max(recursiveDfs(root.left, currentDepth + 1), maxDepth);
        maxDepth = Math.max(recursiveDfs(root.right, currentDepth + 1), maxDepth);
        return maxDepth;
    }
}
