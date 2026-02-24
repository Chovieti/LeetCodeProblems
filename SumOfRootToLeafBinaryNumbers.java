public class TreeNode {
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

public class SumOfRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        return calcSumRoofToLeaf(root, 0);
    }

    private int calcSumRoofToLeaf(TreeNode cur, int val) {
        int tmp = val << 1;
        if (cur.val == 1) tmp |= 1;
        int leftSum = 0, rightSum = 0;
        if (cur.left != null) leftSum = calcSumRoofToLeaf(cur.left, tmp);
        if (cur.right != null) rightSum = calcSumRoofToLeaf(cur.right, tmp);
        return (leftSum + rightSum == 0) ? tmp : leftSum + rightSum;
    }
}
