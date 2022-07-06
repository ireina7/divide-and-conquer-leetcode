package leetcode.problem96;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/unique-binary-search-trees/");
    }
    public abstract int numTrees(int n);
}
