package leetcode.problem700;

public class Solution0 {
    public TreeNode searchBST(TreeNode root, int val) {
        return root == null
            ? null
            : root.val == val ? root
            : root.val <  val ? searchBST(root.right, val)
            : searchBST(root.left, val);
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