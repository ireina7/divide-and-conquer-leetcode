package leetcode.problem538;

import com.sun.source.tree.Tree;

public class Solution0 {
    TreeNode pre;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    /**
     * convert to accumulate tree...
     * @param root the root node
     * @return the leftmost node
     * */
    TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        TreeNode node = dfs(root.right);
        if (node == null) {
            root.val += pre == null ? 0 : pre.val;
        }
        else root.val += node.val;
        pre = root;
        return dfs(root.left);
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