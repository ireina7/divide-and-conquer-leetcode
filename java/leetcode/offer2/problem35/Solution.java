package leetcode.offer2.problem35;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/569nqc/");
    }
    public abstract int findMinDifference(List<String> timePoints);
}
