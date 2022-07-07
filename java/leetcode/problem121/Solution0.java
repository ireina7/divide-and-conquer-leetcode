package leetcode.problem121;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Naive recursion";
    }
    
    int[] prices;
    int pre;
    @Override
    public int maxProfit(int[] prices) {
        this.prices = prices;
        return dfs(prices.length - 1);
    }
    int dfs(int i) {
        if (i == 0) {
            pre = -prices[0];
            return 0;
        }
        int rest = dfs(i - 1);
        int ans = Math.max(rest, pre + prices[i]);
        pre = Math.max(pre, -prices[i]);
        return ans;
    }
}
