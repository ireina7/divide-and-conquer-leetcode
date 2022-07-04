package leetcode.problem860;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/lemonade-change/");
    }
    public abstract boolean lemonadeChange(int[] bills);
}
