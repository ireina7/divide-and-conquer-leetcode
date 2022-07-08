package leetcode.problem718;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/maximum-length-of-repeated-subarray/");
    }
    public abstract int findLength(int[] nums1, int[] nums2);
}
