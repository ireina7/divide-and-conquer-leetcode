package leetcode.problem746;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    @Override
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) return 0;
        int c2 = 0, c1 = 0;
        for (int i = 2; i <= cost.length; ++i) {
            int c0 = Math.min(c1 + cost[i - 1], c2 + cost[i - 2]);
            c2 = c1;
            c1 = c0;
        }
        return c1;
    }
}
