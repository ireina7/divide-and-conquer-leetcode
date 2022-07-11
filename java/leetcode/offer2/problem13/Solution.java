package leetcode.offer2.problem13;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/O4NDxx/");
    }
    public abstract int sumRegion(int row1, int col1, int row2, int col2);
}
