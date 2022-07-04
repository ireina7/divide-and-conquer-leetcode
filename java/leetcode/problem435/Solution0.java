package leetcode.problem435;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    @Override
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(s -> s[0]));
        int[] memo = new int[intervals.length];
        memo[0] = 1;
        int ans = memo[0];
        for (int i = 1; i < intervals.length; ++i) {
            int max = 1;
            int[] cur = intervals[i];
            for (int j = i - 1; j >= 0; --j) {
                if (intervals[j][1] <= cur[0]) {
                    max = Math.max(max, memo[j] + 1);
                    break;
                }
            }
            memo[i] = max;
            ans = Math.max(ans, memo[i]);
        }
        return intervals.length - ans;
    }
}
