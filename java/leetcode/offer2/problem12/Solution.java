package leetcode.offer2.problem12;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/tvdfij/");
    }
    public abstract int pivotIndex(int[] nums);
}
