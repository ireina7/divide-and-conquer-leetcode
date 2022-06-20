package leetcode.problem404;

public class Solution0 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int rs = sumOfLeftLeaves(root.right);
        if (root.left == null) return rs;
        if (root.left.left == null && root.left.right == null) {
            return root.left.val + rs;
        }
        return sumOfLeftLeaves(root.left) + rs;
    }
}

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