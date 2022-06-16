package leetcode.problem144;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution1 {
    List<Integer> ans;
    public List<Integer> preorderTraversal(TreeNode root) {
        this.ans = new ArrayList<>();
        dfs(root);
        return ans;
    }
    void dfs(TreeNode node) {
        if(node == null) return;
        ans.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}
