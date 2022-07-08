package leetcode.problem674;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    int[] nums;
    @Override
    public int findLengthOfLCIS(int[] nums) {
        this.nums = nums;
        return dfs(nums.length - 1);
    }
    int pre;
    int dfs(int i) {
        if (i == 0) {
            pre = 1;
            return 1;
        }
        int rest = dfs(i - 1);
        pre = nums[i] > nums[i - 1] ? pre + 1 : 1;
        return Math.max(rest, pre);
    }
}
