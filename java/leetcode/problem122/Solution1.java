package leetcode.problem122;

public class Solution1 extends Solution {
    @Override
    public String describe() {
        return "Optimized dynamic programming";
    }
    
    @Override
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
    
        int sell = 0;
        int hold = -prices[0];
        for (int i = 1; i < n; ++i) {
            sell = Math.max(sell, hold + prices[i]);
            hold = Math.max(hold, sell - prices[i]);
        }
        return sell;
    }
}
