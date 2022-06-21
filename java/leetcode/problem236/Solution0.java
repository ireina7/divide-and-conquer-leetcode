package leetcode.problem236;

public class Solution0 {
    TreeNode ans, p, q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        dfs(root);
        return ans;
    }
    int dfs(TreeNode root) {
        if (root == null) return 0;
        var ls = dfs(root.left);
        if (ls == 2) return 2;
        var rs = dfs(root.right);
        if (rs == 2) return 2;
        if (ls + rs == 2) {
            ans = root;
            return 2;
        }
        int ms = 0;
        if (root.val == p.val || root.val == q.val) {
            if (ls + rs == 1) {
                ans = root;
                return 2;
            }
            ms = 1;
        }
        return ls + rs + ms;
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