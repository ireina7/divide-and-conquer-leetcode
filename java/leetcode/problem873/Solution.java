package leetcode.problem873;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/");
    }
    public abstract int lenLongestFibSubseq(int[] arr);
}
