package leetcode.problem257;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Solution1 {
    List<List<Integer>> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        this.ans = new ArrayList<>();
        if(root == null) {
            return List.of();
        }
        traverse(root, new ArrayList<>());
        return ans.stream().map(xs -> {
            StringJoiner sj = new StringJoiner("->");
            xs.forEach(x -> sj.add(String.format("%d", x)));
            return sj.toString();
        }).collect(Collectors.toList());
    }
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
    private void traverse(TreeNode root, List<Integer> path) {
        if(isLeaf(root)) {
            path.add(root.val);
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        path.add(root.val);
        if (root.left != null)  traverse(root.left, path);
        if (root.right != null) traverse(root.right, path);
        path.remove(path.size() - 1);
    }
}
