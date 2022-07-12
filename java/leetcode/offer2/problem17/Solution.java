package leetcode.offer2.problem17;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/M1oyTv/");
    }
    public abstract String minWindow(String s, String t);
}
