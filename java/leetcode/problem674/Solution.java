package leetcode.problem674;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/longest-continuous-increasing-subsequence/");
    }
    public abstract int findLengthOfLCIS(int[] nums);
}
