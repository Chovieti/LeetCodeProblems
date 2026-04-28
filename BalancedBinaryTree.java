import java.util.Stack;

public class BalancedBinaryTree {
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
    // Более правильный dfs
    public boolean isBalanced(TreeNode root) {
        return (dfs(root) != -1);
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == -1 || right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }

//    Старый вариант
//    public boolean isBalanced(TreeNode root) {
//        if (root == null) return true;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode tmp = stack.pop();
//            if (tmp.left != null) stack.push(tmp.left);
//            if (tmp.right != null) stack.push(tmp.right);
//            if (!checkSubtree(tmp.left, tmp.right)) return false;
//        }
//        return true;
//    }
//
//    record Pair(TreeNode node, int depth) {}
//
//    private boolean checkSubtree(TreeNode left, TreeNode right) {
//        Stack<Pair> stack = new Stack<>();
//        if (left != null) stack.push(new Pair(left, 1));
//        int leftMaxDeep = calcMaxDepth(stack);
//        if (right != null) stack.push(new Pair(right, 1));
//        int rightMaxDeep = calcMaxDepth(stack);
//        return Math.abs(leftMaxDeep - rightMaxDeep) <= 1;
//    }
//
//    private static int calcMaxDepth(Stack<Pair> stack) {
//        int maxDeep = 0;
//        while (!stack.isEmpty()) {
//            Pair tmp = stack.pop();
//            maxDeep = Math.max(maxDeep, tmp.depth);
//            if (tmp.node.left != null) stack.push(new Pair(tmp.node.left, tmp.depth + 1));
//            if (tmp.node.right != null) stack.push(new Pair(tmp.node.right, tmp.depth + 1));
//        }
//        return maxDeep;
//    }
}
