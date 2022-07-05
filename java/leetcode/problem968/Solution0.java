package leetcode.problem968;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Greedy";
    }
    
    int count = 0;
    @Override
    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (dfs(root) == 0) count += 1;
        return count;
    }
    
    /**
     * return
     * 0 : 表示没有覆盖到
     * 1 : 覆盖到了，但是该节点没有摄像头
     * 2 : 覆盖到了，且该节点有摄像头
     */
    int dfs(TreeNode root) {
        if (root == null) return 1;
        if (root.left == null && root.right == null) {
            return 0;
        }
        int left  = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0) {
            count++;
            return 2;
        }
        if (left == 2 || right == 2) {
            return 1;
        }
        return 0;
    }
}
