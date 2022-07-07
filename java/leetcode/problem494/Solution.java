package leetcode.problem494;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/target-sum/");
    }
    public abstract int findTargetSumWays(int[] nums, int target);
}
