package leetcode.problem392;

import java.util.Arrays;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Divide and conquer";
    }
    
    char[] s;
    char[] t;
    int[][] mem;
    @Override
    public boolean isSubsequence(String s, String t) {
        this.s = s.toCharArray();
        this.t = t.toCharArray();
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        this.mem = new int[s.length()][t.length()];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        return dfs(s.length() - 1, t.length() - 1);
    }
    boolean dfs(int i, int j) {
        if (i == 0 && j == 0) {
            return s[0] == t[0];
        }
        if (mem[i][j] != -1) {
            return mem[i][j] != 0;
        }
        boolean ans = false;
        if (i == 0) {
            ans = s[i] == t[j] || dfs(0, j - 1);
        } else if (j == 0) {
            ans = s[i] == t[j];
        } else {
            if (s[i] != t[j]) {
                ans = dfs(i, j - 1);
            } else {
                ans = dfs(i - 1, j - 1);
            }
        }
        mem[i][j] = ans ? 1 : 0;
        return ans;
    }
}
