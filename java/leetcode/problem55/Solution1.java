package leetcode.problem55;

public class Solution1 extends Solution {
    @Override
    public String describe() {
        return "divide and conquer!";
    }
    
    int[] nums;
    @Override
    public boolean canJump(int[] nums) {
        this.nums = nums;
        return dfs(0) == 0;
    }
    int dfs(int i) {
        if (i == nums.length - 1) {
            return i;
        }
        int j = dfs(i + 1);
        return i + nums[i] < j ? j : i;
    }
}
