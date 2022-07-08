package leetcode.problem309;

import java.util.Arrays;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    int[] prices;
    int[][] pre;
    final int minusInf = Integer.MIN_VALUE;
    @Override
    public int maxProfit(int[] prices) {
        this.prices = prices;
        this.pre = new int[2][2];
        return dfs(prices.length - 1);
    }
    int dfs(int i) {
        if (i == 0) {
            pre[0][0] = 0;
            pre[0][1] = minusInf;
            pre[1][0] = -prices[0];
            return 0;
        }
        dfs(i - 1);
        int[][] dp = new int[2][2];
        for (int j = 0; j < pre.length; ++j) {
            dp[j] = pre[j].clone();
        }
        pre[0][0] = Math.max(dp[0][0], dp[0][1]);
        pre[0][1] = dp[1][0] + prices[i];
        pre[1][0] = Math.max(dp[1][0], dp[0][0] - prices[i]);
        return Math.max(pre[0][0], pre[0][1]);
    }
}








