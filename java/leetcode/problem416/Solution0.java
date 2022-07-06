package leetcode.problem416;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Naive recursion and naive dynamic programming";
    }
    
    int[] nums;
    Map<String, Boolean> memo = new HashMap<>();
    @Override
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        return dfs(sum / 2);
    }
    boolean dfs(int i, int target) {
        if (i == nums.length) return target == 0;
        if (target < 0) return false;
        String key = String.format("%d，%d", i, target);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        boolean ans =
            dfs(i + 1, target) || dfs(i + 1, target - nums[i]);
        memo.put(key, ans);
        return ans;
    }
    boolean dfs(int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[nums.length][0] = true;
        for (int i = nums.length - 1; i >= 0; --i) {
            for (int n = 0; n <= target; ++n) {
                dp[i][n] = dp[i + 1][n] || n >= nums[i] && dp[i + 1][n - nums[i]];
            }
        }
        return dp[0][target];
    }
}
