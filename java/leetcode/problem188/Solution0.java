package leetcode.problem188;

import java.util.Arrays;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Recursion";
    }
    
    int[] prices;
    int[][] pre;
    final int minusInf = Integer.MIN_VALUE;
    @Override
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) return 0;
        this.prices = prices;
        this.pre = new int[k + 1][2];
        return dfs(prices.length - 1);
    }
    int dfs(int i) {
        if (i == 0) {
            for (int[] row : pre) {
                Arrays.fill(row, minusInf);
            }
            pre[0][0] = 0;
            pre[0][1] = -prices[0];
            return 0;
        }
        dfs(i - 1);
        int[][] dp = pre.clone();
        pre[0][1] = Math.max(dp[0][1], -prices[i]);
        for (int k = 1; k < pre.length; ++k) {
            pre[k][0] = Math.max(dp[k][0], dp[k - 1][1] + prices[i]);
            pre[k][1] = Math.max(dp[k][1], dp[k    ][0] - prices[i]);
        }
        return pre[pre.length - 1][0];
    }
}
