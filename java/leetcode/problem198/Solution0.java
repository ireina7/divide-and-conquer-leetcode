package leetcode.problem198;

import java.util.Arrays;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Memorized recursion";
    }
    
    int[] nums;
    int[] memo;
    @Override
    public int rob(int[] nums) {
        this.nums = nums;
        this.memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return dfs(0);
    }
    int dfs(int i) {
        if (i >= nums.length) return 0;
        if (memo[i] != -1) {
            return memo[i];
        }
        int ans = Math.max(dfs(i + 2) + nums[i], dfs(i + 1));
        memo[i] = ans;
        return ans;
    }
}
