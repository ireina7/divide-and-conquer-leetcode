package leetcode.problem98;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/
 * */
public class Solution0 {
    TreeNode max;
    /**
     * Very clever recursion.
     * @param root the root of current tree & the max node which all nodes in root should > max
     * @return whether is valid binary search tree & the max node.
     * */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        return isValidBST(root.right);
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