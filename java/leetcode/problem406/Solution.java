package leetcode.problem406;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/queue-reconstruction-by-height/");
    }
    public abstract int[][] reconstructQueue(int[][] people);
}
