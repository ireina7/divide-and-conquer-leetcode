package leetcode.offer2.problem15;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/VabMRr/");
    }
    public abstract List<Integer> findAnagrams(String s, String p);
}
