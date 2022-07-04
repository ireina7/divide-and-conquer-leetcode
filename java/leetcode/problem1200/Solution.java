package leetcode.problem1200;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/minimum-absolute-difference/");
    }
    public abstract List<List<Integer>> minimumAbsDifference(int[] arr);
}
