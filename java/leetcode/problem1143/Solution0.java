package leetcode.problem1143;

import java.util.Arrays;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    char[] s1;
    char[] s2;
    int[][] mem;
    @Override
    public int longestCommonSubsequence(String text1, String text2) {
        this.s1 = text1.toCharArray();
        this.s2 = text2.toCharArray();
        this.mem = new int[s1.length][s2.length];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        return dfs(s1.length - 1, s2.length - 1);
    }
    int dfs(int i, int j) {
        if (i == 0 && j == 0) {
            return s1[0] == s2[0] ? 1 : 0;
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        int ans = 0;
        if (i == 0) {
            ans = s1[0] == s2[j] ? 1 : dfs(0, j - 1);
        }
        else if (j == 0) {
            ans = s1[i] == s2[0] ? 1 : dfs(i - 1, 0);
        }
        else if (s1[i] != s2[j]) {
            ans = Math.max(dfs(i, j - 1), dfs(i - 1, j));
        }
        else {
            ans = dfs(i - 1, j - 1) + 1;
        }
        mem[i][j] = ans;
        return ans;
    }
}
