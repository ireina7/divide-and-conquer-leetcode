package leetcode.problem343;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/integer-break/");
    }
    public abstract int integerBreak(int n);
}
