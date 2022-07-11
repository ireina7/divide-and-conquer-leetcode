package leetcode.offer2.problem5;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/aseY1I/");
    }
    public abstract int maxProduct(String[] words);
}
