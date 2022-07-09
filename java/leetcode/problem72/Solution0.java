package leetcode.problem72;

import java.util.Arrays;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    char[] s1;
    char[] s2;
    int[][] mem;
    @Override
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty() || word2.isEmpty()) {
            return Math.abs(word1.length() - word2.length());
        }
        this.s1 = word1.toCharArray();
        this.s2 = word2.toCharArray();
        this.mem = new int[s1.length][s2.length];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        return dfs(s1.length - 1, s2.length - 1);
    }
    int dfs(int i, int j) {
        if (i == 0 && j == 0) {
            return s1[0] == s2[0] ? 0 : 1;
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        int ans = 0;
        if (i == 0) {
            ans = s1[i] == s2[j] ? j : dfs(0, j - 1) + 1;
        } else if (j == 0) {
            ans = s1[i] == s2[j] ? i : dfs(i - 1, 0) + 1;
        } else if (s1[i] == s2[j]) {
            ans = dfs(i - 1, j - 1);
        } else {
            ans = Math.min(dfs(i - 1, j), dfs(i, j - 1));
            ans = Math.min(ans, dfs(i - 1, j - 1));
            ans += 1;
        }
        mem[i][j] = ans;
        return ans;
    }
}
