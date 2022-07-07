package leetcode.problem337;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    Map<TreeNode, Integer> memo = new HashMap<>();
    @Override
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int jump = rob(root.left) + rob(root.right);
        int work = root.val;
        if (root.left != null) {
            work += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            work += rob(root.right.left) + rob(root.right.right);
        }
        int ans = Math.max(jump, work);
        memo.put(root, ans);
        return ans;
    }
}
