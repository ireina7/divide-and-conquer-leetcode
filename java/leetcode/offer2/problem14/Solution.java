package leetcode.offer2.problem14;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/MPnaiL/");
    }
    public abstract boolean checkInclusion(String s1, String s2);
}
