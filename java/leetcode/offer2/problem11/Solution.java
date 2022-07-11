package leetcode.offer2.problem11;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/A1NYOS/");
    }
    public abstract int findMaxLength(int[] nums);
}
