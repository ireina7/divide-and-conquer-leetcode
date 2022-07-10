package leetcode.offer.problem3;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/");
    }
    public abstract int findRepeatNumber(int[] nums);
}
