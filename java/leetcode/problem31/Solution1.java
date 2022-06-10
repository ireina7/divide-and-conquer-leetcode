package leetcode.problem31;
import java.util.*;

public class Solution1 {
    int[] nums;
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        this.nums = nums;
        dfs(nums.length - 1, -1);
    }
    int dfs(int i, int pre) {
        if(i < 0) return -1;
        int x = nums[i];
        if(x >= pre) {
            int j = dfs(i - 1, x);
            int k = nums.length - (i - j);
            if(j >= 0 && pre <= nums[j] && x > nums[j]) {
                nums[k] = nums[j];
                nums[j] = x;
            } else {
                nums[k] = x;
            }
            return j;
        }
        return i;
    }
}
