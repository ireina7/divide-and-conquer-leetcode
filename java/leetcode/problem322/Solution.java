package leetcode.problem322;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/coin-change/");
    }
    public abstract int coinChange(int[] coins, int amount);
}
