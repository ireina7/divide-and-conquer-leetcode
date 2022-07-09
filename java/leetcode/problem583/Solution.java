package leetcode.problem583;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/delete-operation-for-two-strings/");
    }
    public abstract int minDistance(String word1, String word2);
}
