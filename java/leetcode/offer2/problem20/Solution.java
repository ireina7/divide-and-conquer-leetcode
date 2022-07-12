package leetcode.offer2.problem20;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/a7VOhD/");
    }
    public abstract int countSubstrings(String s);
}
