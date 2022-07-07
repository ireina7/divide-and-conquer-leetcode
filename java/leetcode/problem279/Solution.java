package leetcode.problem279;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/perfect-squares/");
    }
    public abstract int numSquares(int n);
}
