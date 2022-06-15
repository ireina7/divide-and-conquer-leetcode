package leetcode.problem454;

import java.util.HashMap;
import java.util.Map;

public class Solution0 {
    int[] nums1;
    int[] nums2;
    int[] nums3;
    int[] nums4;
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.nums3 = nums3;
        this.nums4 = nums4;
        return dfs();
    }
    int dfs() {
        Map<Integer, Integer> memo0 = new HashMap<>();
        for(int a : nums1) {
            for(int b : nums2) {
                memo0.put(a + b, memo0.getOrDefault(a + b, 0) + 1);
            }
        }
        int ans = 0;
        for(int a : nums3) {
            for(int b : nums4) {
                int sum = a + b;
                if(memo0.containsKey(-sum)) ans += memo0.get(-sum);
            }
        }
        return ans;
    }
}
