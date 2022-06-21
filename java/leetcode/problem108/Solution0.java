package leetcode.problem108;

public class Solution0 {
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return dfs(0, nums.length - 1);
    }
    TreeNode dfs(int i, int j) {
        if (i > j) return null;
        if (i == j) return new TreeNode(nums[i]);
        int k = i + ((j - i) >> 1);
        TreeNode root = new TreeNode(nums[k]);
        root.left = dfs(i, k - 1);
        root.right = dfs(k + 1, j);
        return root;
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
