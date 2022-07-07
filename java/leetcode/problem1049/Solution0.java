package leetcode.problem1049;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Memorized recursion";
    }
    
    int[] stones;
    @Override
    public int lastStoneWeightII(int[] stones) {
        if (stones.length == 0) return 0;
        this.stones = stones;
        int sum = Arrays.stream(stones).sum();
        return sum - dfs(0, sum / 2);
    }
    Map<String, Integer> memo = new HashMap<>();
    int dfs(int i, int target) {
        if (i >= stones.length) return 0;
        if (target <= 0) return 0;
        String key = String.format("%d,%d", i, target);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int ans = Math.max(
            dfs(i + 1, target),
            target >= stones[i] ? dfs(i + 1, target - stones[i]) + stones[i] : 0
        );
        memo.put(key, ans);
        return ans;
    }
}
