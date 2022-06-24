package leetcode.problem376;


import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/wiggle-subsequence/");
    }
    public abstract int wiggleMaxLength(int[] nums);
}
