package leetcode.problem875;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/koko-eating-bananas/");
    }
    public abstract int minEatingSpeed(int[] piles, int h);
}
