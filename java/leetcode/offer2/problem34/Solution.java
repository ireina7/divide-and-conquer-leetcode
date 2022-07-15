package leetcode.offer2.problem34;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/lwyVBB/");
    }
    public abstract boolean isAlienSorted(String[] words, String order);
}
