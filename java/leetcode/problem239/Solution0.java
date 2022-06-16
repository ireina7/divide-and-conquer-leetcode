package leetcode.problem239;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/sliding-window-maximum/
 * */
public class Solution0 {
    int[] nums;
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < k) return new int[]{};
        this.nums = nums;
        return dfs(k);
    }
    /**
     * Just divide k!
     * */
    int[] dfs(int k) {
        if(k == 1) return nums;
        int kk = k / 2;
        int[] ks = dfs(kk);
        int n = nums.length - k + 1;
        int[] ans = new int[n];
        for(int i = 0; i < n; ++i) {
            int max = Math.max(ks[i], ks[i + kk]);
            if(k % 2 == 1) {
                max = Math.max(nums[i + kk * 2], max);
            }
            ans[i] = max;
        }
        return ans;
    }
}
