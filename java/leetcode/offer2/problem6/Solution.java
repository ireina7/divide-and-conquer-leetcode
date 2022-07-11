package leetcode.offer2.problem6;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/kLl5u1/");
    }
    public abstract int[] twoSum(int[] numbers, int target);
}
