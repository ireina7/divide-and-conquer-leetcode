package leetcode.offer2.problem9;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/ZVAVXX/");
    }
    public abstract int numSubarrayProductLessThanK(int[] nums, int k);
}
