package leetcode.problem332;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public abstract class Solution implements core.Solution {
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/reconstruct-itinerary/");
    }
    public abstract List<String> findItinerary(List<List<String>> tickets);
}
