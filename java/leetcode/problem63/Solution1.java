package leetcode.problem63;

public class Solution1 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int[][] map = obstacleGrid;
        int m = map.length;
        int n = map[0].length;
        
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                memo[i][j] = map[i][j] == 1
                    ? 0
                    : i == 0 && j == 0 ? 1
                    : i == 0 ? memo[i][j-1]
                    : j == 0 ? memo[i-1][j]
                    : memo[i-1][j] + memo[i][j-1];
            }
        }
        return memo[m-1][n-1];
    }
}
