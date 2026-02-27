import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        recursiveBfs(root, builder, result);
        return result;
    }

    private void recursiveBfs(TreeNode root, StringBuilder builder, List<String> res) {
        if (root != null) {
            builder.append(root.val);
        } else {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(builder.toString());
            return;
        }
        builder.append("->");
        if (root.left != null) {
            recursiveBfs(root.left, builder, res);
            builder.setLength(builder.length() - findCharDelete(root.left.val));
        }
        if (root.right != null) {
            recursiveBfs(root.right, builder, res);
            builder.setLength(builder.length() - findCharDelete(root.right.val));
        }
        builder.setLength(builder.length() - 2);
    }

    private int findCharDelete(int number) {
        int charDelete = (number >= 0) ? 0 : 1;
        number = Math.abs(number);
        if (number >= 0 && number < 10) {
            charDelete += 1;
        } else if (number >= 10 && number < 100) {
            charDelete += 2;
        } else {
            charDelete += 3;
        }
        return charDelete;
    }
}
