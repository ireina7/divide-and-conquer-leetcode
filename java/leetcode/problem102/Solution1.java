package leetcode.problem102;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    List<List<Integer>> ans;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.ans = new ArrayList<>();
        dfs(root, 0);
        return ans;
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
