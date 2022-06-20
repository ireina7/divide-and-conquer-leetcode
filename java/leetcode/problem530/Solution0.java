package leetcode.problem530;

public class Solution0 {
    TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        return dfs(root);
    }
    int dfs(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        int left = dfs(root.left);
        int mid = Integer.MAX_VALUE;
        if (pre != null) {
            mid = Math.abs(root.val - pre.val);
        }
        pre = root;
        int right = dfs(root.right);
        return Math.min(left, Math.min(mid, right));
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