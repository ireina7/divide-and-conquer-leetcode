package leetcode.offer2.problem10;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/QTMn0o/");
    }
    public abstract int subarraySum(int[] nums, int k);
}
