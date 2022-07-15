package leetcode.problem67;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/add-binary/");
    }
    public abstract String addBinary(String a, String b);
}
