package leetcode.problem1143;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/longest-common-subsequence/");
    }
    public abstract int longestCommonSubsequence(String text1, String text2);
}
