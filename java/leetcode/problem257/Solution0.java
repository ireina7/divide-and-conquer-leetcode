package leetcode.problem257;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Solution0 {
    List<List<Integer>> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return List.of();
        this.ans = dfs(root);
        return ans.stream().map(xs -> {
            StringJoiner sj = new StringJoiner("->");
            xs.forEach(x -> sj.add(String.format("%d", x)));
            return sj.toString();
        }).collect(Collectors.toList());
    }
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
    private List<List<Integer>> dfs(TreeNode node) {
        if(isLeaf(node)) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            cur.add(node.val);
            ans.add(cur);
            return ans;
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> ls = node.left == null ? List.of() : dfs(node.left);
        List<List<Integer>> rs = node.right == null ? List.of() : dfs(node.right);
        ans.addAll(ls);
        ans.addAll(rs);
        for (List<Integer> xs : ans) {
            xs.add(0, node.val);
        }
        return ans;
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