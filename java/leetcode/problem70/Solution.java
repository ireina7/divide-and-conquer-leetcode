package leetcode.problem70;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/climbing-stairs/");
    }
    public abstract int climbStairs(int n);
}
