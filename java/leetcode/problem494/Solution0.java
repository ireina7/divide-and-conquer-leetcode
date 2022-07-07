package leetcode.problem494;

import java.util.HashMap;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Memorized recursion";
    }
    
    int[] nums;
    @Override
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        return dfs(0, target);
    }
    Map<String, Integer> memo = new HashMap<>();
    int dfs(int i, int target) {
        if (i >= nums.length) return target == 0 ? 1 : 0;
        String key = String.format("%d,%d", i, target);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int ans = dfs(i + 1, target - nums[i]) + dfs(i + 1, target + nums[i]);
        memo.put(key, ans);
        return ans;
    }
}
