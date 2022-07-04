package leetcode.problem452;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/");
    }
    public abstract int findMinArrowShots(int[][] points);
}
