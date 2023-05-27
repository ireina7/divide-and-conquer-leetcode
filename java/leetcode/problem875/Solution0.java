package leetcode.problem875;

import java.util.Arrays;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "divide ans conquer!";
    }
    
    @Override
    public int minEatingSpeed(int[] piles, int h) {
        return eatMost(piles, h);
    }
    int[] piles;
    int hour;
    int eatMost(int[] piles, int h) {
        this.piles = piles;
        this.hour = h;
        return dfs(1, Arrays.stream(piles).max().getAsInt());
    }
    
    int dfs(int i, int j) {
        if (i > j) {
            return Integer.MAX_VALUE;
        }
        int mid = i + (j - i) / 2;
        int cost = eat(mid);
        if (cost > hour) {
            return dfs(mid + 1, j);
        }
        return i == mid ? i : dfs(i, mid);
    }
    int eat(int k) {
        int ans = 0;
        for (int pile : piles) {
            if (pile % k == 0) {
                ans += pile / k;
                continue;
            }
            ans += pile / k + 1;
        }
        return ans;
    }
}
