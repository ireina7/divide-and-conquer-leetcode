package leetcode.problem55;

import java.util.HashMap;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Bad dynamic programming";
    }
    
    int[] nums;
    Map<Integer, Boolean> memo = new HashMap<>();
    @Override
    public boolean canJump(int[] nums) {
        this.nums = nums;
        return dfs(0);
    }
    boolean dfs(int i) {
        if (i == nums.length - 1) {
            return true;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        for (int d = 1; d <= nums[i]; ++d) {
            if (dfs(i + d)) {
                memo.put(i, true);
                return true;
            }
        }
        memo.put(i, false);
        return false;
    }
}
