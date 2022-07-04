package leetcode.problem452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    @Override
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));
        int[] dp = new int[points.length];
        dp[0] = 1;
        int ans = dp[0];
        for (int i = 1; i < points.length; i++) {
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (points[j][1] < points[i][0]) {
                    max = Math.max(max, dp[j] + 1);
                    break;
                }
            }
            dp[i] = max;
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
