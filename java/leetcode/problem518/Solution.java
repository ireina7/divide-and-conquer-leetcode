package leetcode.problem518;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/coin-change-2/");
    }
    public abstract int change(int amount, int[] coins);
}
