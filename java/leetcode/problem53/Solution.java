package leetcode.problem53;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/maximum-subarray/");
    }
    public abstract int maxSubArray(int[] nums);
}
