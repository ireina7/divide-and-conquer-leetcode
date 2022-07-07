package leetcode.problem121;

public class Solution1 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    @Override
    public int maxProfit(int[] prices) {
        int hold = -prices[0], sold = 0;
        for (int i = 1; i < prices.length; ++i) {
            sold = Math.max(sold, hold + prices[i]);
            hold = Math.max(hold, -prices[i]);
        }
        return sold;
    }
}
