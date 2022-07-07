package leetcode.problem139;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/word-break/");
    }
    public abstract boolean wordBreak(String s, List<String> wordDict);
}
