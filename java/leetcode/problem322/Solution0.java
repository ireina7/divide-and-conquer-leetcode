package leetcode.problem322;

import java.util.HashMap;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Memorized recursion";
    }
    
    int[] coins;
    @Override
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        return dfs(amount);
    }
    Map<Integer, Integer> memo = new HashMap<>();
    int dfs(int amount) {
        if (amount == 0) return 0;
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        int ans = -1;
        for (int coin : coins) {
            if (coin <= amount) {
                int rest = dfs(amount - coin);
                if (rest == -1) continue;
                ans = ans == -1 ? 1 + rest : Math.min(ans, 1 + rest);
            }
        }
        memo.put(amount, ans);
        return ans;
    }
}
