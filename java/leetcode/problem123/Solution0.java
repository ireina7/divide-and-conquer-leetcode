package leetcode.problem123;

import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    int[] prices;
    int[][] pre;
    final int minusInf = Integer.MIN_VALUE;
    @Override
    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.pre = new int[3][2];
        return dfs(prices.length - 1);
    }
    int dfs(int i) {
        if (i == 0) {
            pre[0][0] = 0;
            pre[0][1] = -prices[0];
            pre[1][0] = minusInf;
            pre[1][1] = minusInf;
            pre[2][0] = minusInf;
            pre[2][1] = minusInf;
            return minusInf;
        }
        dfs(i - 1);
        int[][] dp = pre.clone();
        pre[0][1] = Math.max(dp[0][1], -prices[i]);
        pre[1][0] = Math.max(dp[1][0], dp[0][1] + prices[i]);
        pre[1][1] = Math.max(dp[1][1], dp[1][0] - prices[i]);
        pre[2][0] = Math.max(dp[2][0], dp[1][1] + prices[i]);
        return pre[2][0];
    }
}
