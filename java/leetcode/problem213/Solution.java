package leetcode.problem213;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/house-robber-ii/");
    }
    public abstract int rob(int[] nums);
}
