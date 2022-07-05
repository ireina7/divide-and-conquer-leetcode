package leetcode.problem62;

import java.util.HashMap;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Memorized recursion";
    }
    
    int m, n;
    Map<String, Integer> memo = new HashMap<>();
    @Override
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        return dfs(1, 1);
    }
    int dfs(int i, int j) {
        if (i == m || j == n) {
            return 1;
        }
        String key = String.format("%d,%d", i, j);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int ans = dfs(i + 1, j) + dfs(i, j + 1);
        memo.put(key, ans);
        return ans;
    }
}
