package leetcode.problem94;

import java.util.ArrayList;
import java.util.List;

public class Solution0 {
    List<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
        this.ans = new ArrayList<>();
        dfs(root);
        return ans;
    }
    void dfs(TreeNode node) {
        if(node == null) return;
        dfs(node.left);
        ans.add(node.val);
        dfs(node.right);
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
