package leetcode.problem72;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/edit-distance/");
    }
    public abstract int minDistance(String word1, String word2);
}
