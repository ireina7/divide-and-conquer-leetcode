package leetcode.problem518;

import java.util.HashMap;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    int[] coins;
    @Override
    public int change(int amount, int[] coins) {
        this.coins = coins;
        return dfs(0, amount);
    }
    Map<String, Integer> memo = new HashMap<>();
    int dfs(int i, int amount) {
        if (i >= coins.length) return amount == 0 ? 1 : 0;
        if (amount <= 0) return 1;
        String key = String.format("%d,%d", i, amount);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int ans = 0;
        for (int n = 0; n * coins[i] <= amount; ++n) {
            ans += dfs(i + 1, amount - n * coins[i]);
        }
        memo.put(key, ans);
        return ans;
    }
    
    // Alright, let's convert this into dynamic programming form.
    int dfs(int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[coins.length][0] = 1;
        for (int i = 0; i <= coins.length; ++i) {
            dp[i][0] = 1;
        }
        for (int i = coins.length - 1; i >= 0; --i) {
            for (int n = 1; n <= amount; ++n) {
                for (int k = 0; k * coins[i] <= n; ++k) {
                    dp[i][n] += dp[i + 1][n - k * coins[i]];
                }
            }
        }
        return dp[0][amount];
    }
}
