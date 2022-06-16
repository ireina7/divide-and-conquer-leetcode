package leetcode.problem102;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution0 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return List.of();
        return dfs(root);
    }
    List<List<Integer>> dfs(TreeNode root) {
        if(root == null) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            return ans;
        }
        var ls = dfs(root.left);
        var rs = dfs(root.right);
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, j = 0;
        while(i < ls.size() && j < rs.size()) {
            if(ls.get(i).size() == 0 && rs.get(j).size() == 0) {
                ++i; ++j;
                continue;
            }
            ans.add(
                Stream.concat(ls.get(i).stream(), rs.get(j).stream())
                    .collect(Collectors.toList())
            );
            ++i; ++j;
        }
        if(i < ls.size()) {
            for(; i < ls.size(); ++i) {
                if(ls.get(i).size() > 0) ans.add(ls.get(i));
            }
        }
        if(j < rs.size()) {
            for(; j < rs.size(); ++j) {
                if(rs.get(j).size() > 0) ans.add(rs.get(j));
            }
        }
        List<Integer> cur = new ArrayList<>();
        cur.add(root.val);
        ans.add(0, cur);
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
