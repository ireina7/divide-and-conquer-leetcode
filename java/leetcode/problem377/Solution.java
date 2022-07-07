package leetcode.problem377;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/combination-sum-iv/");
    }
    public abstract int combinationSum4(int[] nums, int target);
}
