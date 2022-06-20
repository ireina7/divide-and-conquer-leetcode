package leetcode.problem112;

public class Solution0 {
    int sum;
    int targetSum;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        this.sum = 0;
        this.targetSum = targetSum;
        return dfs(root);
    }
    boolean dfs(TreeNode node) {
        if (node == null) return false;
        if (isLeaf(node)) {
            return sum + node.val == targetSum;
        }
        sum += node.val;
        boolean ans = dfs(node.left) || dfs(node.right);
        sum -= node.val;
        return ans;
    }
    boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}