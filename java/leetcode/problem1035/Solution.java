package leetcode.problem1035;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/uncrossed-lines/");
    }
    public abstract int maxUncrossedLines(int[] nums1, int[] nums2);
}
