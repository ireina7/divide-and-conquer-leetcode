package leetcode.problem560;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/subarray-sum-equals-k/");
    }
    public abstract int subarraySum(int[] nums, int k);
}
