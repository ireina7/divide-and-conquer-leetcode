package leetcode.problem137;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/single-number-ii/");
    }
    public abstract int singleNumber(int[] nums);
}
