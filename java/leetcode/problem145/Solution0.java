package leetcode.problem145;

import java.util.ArrayList;
import java.util.List;

public class Solution0 {
    List<Integer> ans;
    public List<Integer> postorderTraversal(TreeNode root) {
        this.ans = new ArrayList<>();
        dfs(root);
        return ans;
    }
    void dfs(TreeNode node) {
        if(node == null) return;
        dfs(node.left);
        dfs(node.right);
        ans.add(node.val);
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