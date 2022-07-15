package leetcode.offer2.problem35;

import java.util.List;
import java.util.stream.Collectors;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.isEmpty()) return -1;
        List<Integer> ss = timePoints.stream().map(s -> {
            int h = Integer.parseInt(s.substring(0, 2));
            int m = Integer.parseInt(s.substring(3));
            return h * 60 + m;
        }).sorted().collect(Collectors.toList());
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < ss.size(); ++i) {
            ans = Math.min(ans, ss.get(i) - ss.get(i - 1));
        }
        ans = Math.min(ans, 24 * 60 + ss.get(0) - ss.get(ss.size() - 1));
        return ans;
    }
}
