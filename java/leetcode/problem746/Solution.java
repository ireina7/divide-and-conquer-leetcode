package leetcode.problem746;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/min-cost-climbing-stairs/");
    }
    public abstract int minCostClimbingStairs(int[] cost);
}
