package leetcode.problem115;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Recursion";
    }
    
    char[] s;
    char[] t;
    int[][] mem;
    @Override
    public int numDistinct(String s, String t) {
        this.s = s.toCharArray();
        this.t = t.toCharArray();
        this.mem = new int[s.length()][t.length()];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }
        int ans = dfs(s.length() - 1, t.length() - 1);
        return ans;
    }
    int dfs(int i, int j) {
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        if (i == 0 && j == 0) {
            mem[i][j] = s[0] == t[0] ? 1 : 0;
            return s[0] == t[0] ? 1 : 0;
        }
        int ans = 0;
        if (i == 0) {
            ans = 0;
        } else if (j == 0) {
            ans = (s[i] == t[j] ? 1 : 0) + dfs(i - 1, j);
        } else {
            if (s[i] != t[j]) {
                ans = dfs(i - 1, j);
            } else {
                ans = dfs(i - 1, j) + dfs(i - 1, j - 1);
            }
        }
        mem[i][j] = ans;
        return ans;
    }
}


