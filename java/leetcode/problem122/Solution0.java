package leetcode.problem122;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Naive dynamic programming";
    }
    
    @Override
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        
        int[][] memo = new int[n][2];
        memo[0][0] = 0;
        memo[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            memo[i][0] = Math.max(memo[i - 1][0], memo[i - 1][1] + prices[i]);
            memo[i][1] = Math.max(memo[i - 1][1], memo[i - 1][0] - prices[i]);
        }
        return memo[n - 1][0];
    }
}
