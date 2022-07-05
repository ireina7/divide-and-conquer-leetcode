package leetcode.problem62;

import java.util.HashMap;
import java.util.Map;

public class Solution1 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    @Override
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m + 1][n + 1];
        for (int i = m; i > 0; --i) {
            for (int j = n; j > 0; --j) {
                memo[i][j] = i == m || j == n
                    ? 1
                    : memo[i + 1][j] + memo[i][j + 1];
            }
        }
        return memo[1][1];
    }
}
