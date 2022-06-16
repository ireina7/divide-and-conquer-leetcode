package leetcode.problem1089;

public class Solution0 {
    int[] nums;
    public void duplicateZeros(int[] arr) {
        this.nums = arr;
        dfs(0, 0);
    }
    void dfs(int i, int j) {
        if(i >= nums.length || j >= nums.length) return;
        if(nums[i] != 0) {
            dfs(i + 1, j + 1);
            nums[j] = nums[i];
            return;
        }
        dfs(i + 1, j + 2);
        nums[j] = 0;
        if(j + 1 < nums.length) nums[j + 1] = 0;
    }
}
