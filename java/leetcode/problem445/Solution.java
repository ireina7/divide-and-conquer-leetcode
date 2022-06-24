package leetcode.problem445;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/assign-cookies/");
    }
    public abstract int findContentChildren(int[] g, int[] s);
}
