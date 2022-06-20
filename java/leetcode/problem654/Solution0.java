package leetcode.problem654;

public class Solution0 {
    int[] nums;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return dfs(0, nums.length - 1);
    }
    TreeNode dfs(int i, int j) {
        if (i > j) return null;
        if (i == j) return new TreeNode(nums[i]);
        int maxIndex = i;
        for(int k = i; k <= j; ++k) {
            if (nums[k] > nums[maxIndex]) {
                maxIndex = k;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = dfs(i, maxIndex - 1);
        root.right = dfs(maxIndex + 1, j);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {
    }
    
    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}