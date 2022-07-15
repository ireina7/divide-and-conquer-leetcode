package leetcode.offer2.problem57;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/7WqeDu/");
    }
    public abstract boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t);
}
