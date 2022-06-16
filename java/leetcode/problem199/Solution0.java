package leetcode.problem199;

import java.util.ArrayList;
import java.util.List;

public class Solution0 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        ans.add(root.val);
        var ls = rightSideView(root.left);
        var rs = rightSideView(root.right);
        ans.addAll(rs);
        if(ls.size() > rs.size()) {
            for(int i = rs.size(); i < ls.size(); ++i) {
                ans.add(ls.get(i));
            }
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
