package leetcode.problem99;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    TreeNode pre;
    TreeNode node1;
    TreeNode node2;
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
        
    }
}
