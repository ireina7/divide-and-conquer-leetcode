package leetcode.problem416;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    int[] nums;
    @Override
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        return dfs(sum / 2);
    }
    
    boolean dfs(int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = nums.length - 1; i >= 0; --i) {
            boolean[] dpre = dp.clone();
            for (int n = 0; n <= target; ++n) {
                dp[n] = dpre[n] || n >= nums[i] && dpre[n - nums[i]];
            }
        }
        return dp[target];
    }
}
