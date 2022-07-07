package leetcode.problem279;

import java.util.HashMap;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Memorized recursion";
    }
    
    @Override
    public int numSquares(int n) {
        return dfs(n);
    }
    Map<Integer, Integer> memo = new HashMap<>();
    int dfs(int n) {
        if (n == 0) return 0;
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int ans = n;
        for (int i = 1; i <= n / i; ++i) {
            ans = Math.min(ans, 1 + dfs(n - i * i));
        }
        memo.put(n, ans);
        return ans;
    }
}
