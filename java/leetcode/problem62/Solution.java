package leetcode.problem62;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/unique-paths/");
    }
    public abstract int uniquePaths(int m, int n);
}
