package leetcode.problem122;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/");
    }
    public abstract int maxProfit(int[] prices);
}
