package leetcode.problem669;

public class Solution0 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low ) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left , low, high);
        root.left  = trimBST(root.left , low, high);
        root.right = trimBST(root.right, low, high);
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