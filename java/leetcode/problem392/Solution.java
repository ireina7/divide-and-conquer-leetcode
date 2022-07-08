package leetcode.problem392;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/is-subsequence/");
    }
    public abstract boolean isSubsequence(String s, String t);
}
