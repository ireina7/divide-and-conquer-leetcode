package leetcode.problem122;

public class Solution3 extends Solution {
    @Override
    public String describe() {
        return "Greedy algorithm";
    }

    @Override
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }
        return ans;
    }
}
