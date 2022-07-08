package leetcode.problem300;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Divide and recursion";
    }
    
    int[] nums;
    int[] memo;
    @Override
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        this.memo = new int[nums.length];
        return dfs(nums.length - 1);
    }
    int dfs(int i) {
        if (i == 0) {
            memo[0] = 1;
            return 1;
        }
        int pre = dfs(i - 1);
        int ans = 1;
        for (int j = 0; j < i; ++j) {
            if (nums[j] < nums[i]) {
                ans = Math.max(ans, 1 + memo[j]);
            }
        }
        memo[i] = ans;
        return Math.max(pre, ans);
    }
}
