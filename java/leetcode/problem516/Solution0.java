package leetcode.problem516;

import java.util.Arrays;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Memorized recursion";
    }
    
    char[] s;
    int[][] memo;
    @Override
    public int longestPalindromeSubseq(String s) {
        this.s = s.toCharArray();
        this.memo = new int[s.length()][s.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, s.length() - 1);
    }
    int dfs(int i, int j) {
        if (i > j) return 0;
        if (i + 1 == j) return s[i] == s[j] ? 2 : 1;
        if (i == j) return 1;
        
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int ans = 0;
        if (s[i] == s[j]) {
            ans = 2 + dfs(i + 1, j - 1);
        } else {
            ans = Math.max(ans, dfs(i, j - 1));
            ans = Math.max(ans, dfs(i + 1, j));
        }
        memo[i][j] = ans;
        return ans;
    }
}

// f i j = max (f i (j - 1)) $
//    if s[i] == s[j] then 2 + f (i + 1) (j - 1)
//    else f (i + 1) j

