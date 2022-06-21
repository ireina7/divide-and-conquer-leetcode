package leetcode.problem236;

public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode ls = lowestCommonAncestor(root.left , p, q);
        TreeNode rs = lowestCommonAncestor(root.right, p, q);
        if(ls == null) return rs;
        if(rs == null) return ls;
        return root;
    }
}
