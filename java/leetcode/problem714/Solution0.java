package leetcode.problem714;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    @Override
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int sell = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            sell = Math.max(sell, hold + prices[i] - fee);
            hold = Math.max(hold, sell - prices[i]);
        }
        return sell;
    }
}
