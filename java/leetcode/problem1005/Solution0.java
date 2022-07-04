package leetcode.problem1005;

import java.util.Arrays;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Greedy";
    }
    
    @Override
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && k > 0 && nums[i] < 0; ++i, --k) {
            nums[i] *= -1;
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int n: nums) {
            ans += n;
            min = Math.min(min, n);
        }
        return k % 2 == 0 ? ans : ans - min * 2;
    }
}
