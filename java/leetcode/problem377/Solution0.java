package leetcode.problem377;

import java.util.HashMap;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Memorized recursion";
    }
    
    int[] nums;
    @Override
    public int combinationSum4(int[] nums, int target) {
        this.nums = nums;
        return dfs(target);
    }
    Map<Integer, Integer> memo = new HashMap<>();
    int dfs(int target) {
        if (target == 0) return 1;
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        int ans = 0;
        for (int num : nums) {
            ans += num <= target ? dfs(target - num) : 0;
        }
        memo.put(target, ans);
        return ans;
    }
}
