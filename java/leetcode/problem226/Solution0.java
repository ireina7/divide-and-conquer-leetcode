package leetcode.problem226;

public class Solution0 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        var tr = invertTree(root.right);
        var tl = invertTree(root.left);
        root.left = tr;
        root.right = tl;
        return root;
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