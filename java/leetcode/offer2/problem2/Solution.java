package leetcode.offer2.problem2;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/JFETK5/");
    }
    public abstract String addBinary(String a, String b);
}
