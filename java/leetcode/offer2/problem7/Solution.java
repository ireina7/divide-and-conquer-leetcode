package leetcode.offer2.problem7;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/1fGaJU/");
    }
    public abstract List<List<Integer>> threeSum(int[] nums);
}
