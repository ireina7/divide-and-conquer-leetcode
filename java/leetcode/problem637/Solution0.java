package leetcode.problem637;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution0 {
    List<List<Integer>> ans;
    public List<Double> averageOfLevels(TreeNode root) {
        this.ans = new ArrayList<>();
        dfs(root, 0);
        return ans.stream().map(xs ->
            xs.stream().map(i -> (double)i).reduce(0.0, Double::sum) / xs.size()
        ).collect(Collectors.toList());
    }
    void dfs(TreeNode node, int depth) {
        if(node == null) return;
        if(ans.size() < depth + 1) {
            ans.add(new ArrayList<>());
        }
        ans.get(depth).add(node.val);
        dfs(node.left , depth + 1);
        dfs(node.right, depth + 1);
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