package leetcode.problem343;

import java.util.HashMap;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Memorized recursion";
    }
    
    Map<Integer, Integer> memo = new HashMap<>();
    @Override
    public int integerBreak(int n) {
        if (n <= 3) return n - 1;
        return dfs(n);
    }
    int dfs(int n) {
        if (n <= 2) return 1;
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int ans = 1;
        for (int i = 1; i <= n; ++i) {
            ans = Math.max(ans, dfs(n - i) * i);
        }
        memo.put(n, ans);
        return ans;
    }
}
