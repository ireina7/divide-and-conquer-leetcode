package leetcode.problem110;

public class Solution0 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }
        int dl = depth(root.left);
        int dr = depth(root.right);
        return Math.abs(dl - dr) <= 1;
    }
    private int depth(TreeNode node) {
        if(node == null) return 0;
        return 1 + Math.max(depth(node.left), depth(node.right));
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