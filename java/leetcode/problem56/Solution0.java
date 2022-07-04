package leetcode.problem56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    int[][] ranges;
    @Override
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        this.ranges = intervals;
        var res = dfs(ranges.length - 1);
        int[][] ans = new int[res.size()][];
        for (int i = 0; i < res.size(); ++i) {
            ans[i] = res.get(i);
        }
        return ans;
    }
    List<int[]> dfs(int i) {
        if (i < 0) {
            return new ArrayList<>();
        }
        var rest = dfs(i - 1);
        if (rest.isEmpty()) {
            rest.add(ranges[i]);
            return rest;
        }
        int[] last = rest.get(rest.size() - 1);
        if (last[1] < ranges[i][0]) {
            rest.add(ranges[i]);
            return rest;
        }
        last[1] = Math.max(last[1], ranges[i][1]);
        return rest;
    }
}
