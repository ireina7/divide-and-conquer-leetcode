package leetcode.problem376;

public class Solution1 extends Solution {
    @Override
    public String describe() {
        return "Greedy algorithm";
    }
    
    @Override
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int ans = 1;
        int pre = 0;
        for (int i = 0; i < nums.length; ++i) {
            int diff = nums[i] - nums[i - 1];
            if (diff == 0) continue;
            if (pre * diff <= 0) ans += 1;
            pre = diff;
        }
        return ans;
    }
}
