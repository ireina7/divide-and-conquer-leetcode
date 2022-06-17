package leetcode.problem101;

/**
 * https://leetcode.cn/problems/symmetric-tree/
 * */
public class Solution0 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return check(root.left, root.right);
    }
    boolean check(TreeNode l, TreeNode r) {
        if(l == null && r == null) return true;
        if(l == null || r == null) return false;
        if(l.val != r.val) return false;
        return check(l.right, r.left) && check(l.left, r.right);
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