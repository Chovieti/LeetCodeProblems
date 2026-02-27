public class InvertBinaryTree {
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

    public TreeNode invertTree(TreeNode root) {
        recursiveInvert(root);
        return root;
    }

    private void recursiveInvert(TreeNode root) {
        if (root == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        recursiveInvert(root.left);
        recursiveInvert(root.right);
    }
}
