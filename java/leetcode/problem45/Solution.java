package leetcode.problem45;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/jump-game-ii/");
    }
    public abstract int jump(int[] nums);
}
