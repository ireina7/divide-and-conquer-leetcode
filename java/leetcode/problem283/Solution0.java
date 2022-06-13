package leetcode.problem283;
import java.util.*;

public class Solution0 {
    int[] nums;
    public void moveZeroes(int[] nums) {
        this.nums = nums;
        dfs(nums.length - 1);
    }
    int dfs(int i) {
        if(i == 0) {
            if(nums[0] == 0) return 0;
            return 1;
        }
        int j = dfs(i - 1);
        if(nums[i] == 0) return j;
        int x = nums[j];
        nums[j] = nums[i];
        nums[i] = x;
        return j + 1;
    }
}
