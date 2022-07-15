package leetcode.problem814;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Recursion";
    }
    
    @Override
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        TreeNode ls = pruneTree(root.left);
        TreeNode rs = pruneTree(root.right);
        if (root.val == 0 && ls == null && rs == null) {
            return null;
        }
        root.left = ls;
        root.right = rs;
        return root;
    }
}
