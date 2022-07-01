package leetcode.problem122;

public class Solution2 extends Solution {
    @Override
    public String describe() {
        return "Divide and conquer!";
    }
    
    int[] dfs(int[] ps, int i) {
        if(i == 0) {
            return new int[]{0, -ps[0]};
        }
        int[] pre = dfs(ps, i - 1);
        int[] ans = new int[2];
        ans[0] = Math.max(pre[0], pre[1] + ps[i]);
        ans[1] = Math.max(pre[1], pre[0] - ps[i]);
        return ans;
    }
    @Override
    public int maxProfit(int[] prices) {
        int[] ans = dfs(prices, prices.length - 1);
        return ans[0];
    }
}
