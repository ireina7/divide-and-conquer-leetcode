package leetcode.offer2.problem12;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
    
        int cur = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((sum - nums[i]) % 2 == 0 && cur == (sum - nums[i]) / 2) return i;
            cur += nums[i];
        }
        return -1;
    }
}
