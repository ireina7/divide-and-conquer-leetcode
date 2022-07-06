package leetcode.problem63;

import java.util.HashMap;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Naive recursion";
    }
    
    int[][] map;
    int m, n;
    Map<String, Integer> memo = new HashMap<>();
    @Override
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        this.map = obstacleGrid;
        this.m = map.length;
        this.n = map[0].length;
        return dfs(0, 0);
    }
    int dfs(int i, int j) {
        if (i >= m || j >= n || i < 0 || j < 0 || map[i][j] == 1) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) return 1;
        String key = String.format("%d,%d", i, j);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (i == m - 1) {
            for (; j < n; ++j) {
                if (map[i][j] == 1) {
                    memo.put(key, 0);
                    return 0;
                }
            }
            memo.put(key, 1);
            return 1;
        }
        if (j == n - 1) {
            for (; i < m; ++i) {
                if (map[i][j] == 1) {
                    memo.put(key, 0);
                    return 0;
                }
            }
            memo.put(key, 1);
            return 1;
        }
        int ans = dfs(i + 1, j) + dfs(i, j + 1);
        memo.put(key, ans);
        return ans;
    }
}
