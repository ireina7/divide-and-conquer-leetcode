package leetcode.offer2.problem8;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    @Override
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0, j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (; j < nums.length; ++j) {
            sum += nums[j];
            if (sum < target) continue;
            while (i <= j && sum >= target) {
                sum -= nums[i];
                i += 1;
            }
            ans = Math.min(ans, j - i + 2);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
