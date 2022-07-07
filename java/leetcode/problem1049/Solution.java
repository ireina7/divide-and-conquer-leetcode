package leetcode.problem1049;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/last-stone-weight-ii/");
    }
    public abstract int lastStoneWeightII(int[] stones);
}
