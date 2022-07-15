package leetcode.offer2.problem3;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/w3tCBm/");
    }
    public abstract int[] countBits(int n);
}
