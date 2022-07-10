package leetcode.offer2.problem1;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/xoh6Oh/");
    }
    public abstract int divide(int a, int b);
}
