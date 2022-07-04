package leetcode.problem1005;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/");
    }
    public abstract int largestSumAfterKNegations(int[] nums, int k);
}
