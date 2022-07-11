package leetcode.offer2.problem8;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/2VG8Kg/");
    }
    public abstract int minSubArrayLen(int target, int[] nums);
}
