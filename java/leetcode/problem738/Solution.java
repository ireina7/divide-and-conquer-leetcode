package leetcode.problem738;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/monotone-increasing-digits/");
    }
    public abstract int monotoneIncreasingDigits(int n);
}
