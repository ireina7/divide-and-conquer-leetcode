package leetcode.problem99;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Naive recursion";
    }
    
    TreeNode pre;
    TreeNode node1, node2;
    @Override
    public void recoverTree(TreeNode root) {
        this.pre = null;
        this.node1 = null;
        this.node2 = null;
        dfs(root);
        int val = node1.val;
        node1.val = node2.val;
        node2.val = val;
    }
    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null && root.val <= pre.val) {
            if (node1 == null) {
                node1 = pre;
                node2 = root;
            }
            else node2 = root;
        }
        pre = root;
        dfs(root.right);
    }
}
