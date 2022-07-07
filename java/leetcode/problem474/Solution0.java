package leetcode.problem474;

import java.util.*;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    String[] strs;
    List<int[]> counts = new ArrayList<>();
    @Override
    public int findMaxForm(String[] strs, int m, int n) {
        this.strs = strs;
        for (String s : strs) counts.add(count(s));
        return dfs(m, n);
    }
    Map<String, Integer> memo = new HashMap<>();
    int dfs(int i, int m, int n) {
        if (i >= strs.length) return 0;
        if (m <= 0 && n <= 0) return 0;
        String key = String.format("%d,%d,%d", i, m, n);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int[] cnt = counts.get(i);
        int ans = Math.max(
            dfs(i + 1, m, n),
            (m >= cnt[0] && n >= cnt[1]) ? dfs(i + 1, m - cnt[0], n - cnt[1]) + 1 : 0
        );
        memo.put(key, ans);
        return ans;
    }
    // Unfortunately, we have to translate recursion to dynamic programming form...
    int dfs(int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            Arrays.fill(dp[strs.length][i], 0);
        }
        for (int i = 0; i <= strs.length; ++i) {
            dp[i][0][0] = 0;
        }
        for (int i = strs.length - 1; i >= 0; --i) {
            int[] cnt = counts.get(i);
            for (int j = 0; j <= m; ++j) {
                for (int k = 0; k <= n; ++k) {
                    dp[i][j][k] = Math.max(
                        dp[i + 1][j][k],
                        (j >= cnt[0] && k >= cnt[1]) ? dp[i + 1][j - cnt[0]][k - cnt[1]] + 1 : 0
                    );
                }
            }
        }
        return dp[0][m][n];
    }
    int[] count(String s) {
        int[] ans = new int[2];
        for (char c : s.toCharArray()) {
            if (c == '0') ans[0] += 1;
            else if (c == '1') ans[1] += 1;
        }
        return ans;
    }
}
