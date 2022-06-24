package leetcode.problem53;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    @Override
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int pre = nums[0];
        int ans = pre;
        for (int i = 1; i < nums.length; ++i) {
            pre = Math.max(pre, 0) + nums[i];
            ans = Math.max(ans, pre);
        }
        return ans;
    }
}
