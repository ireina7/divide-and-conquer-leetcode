package leetcode.problem34;
import java.util.*;

/**
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * */
public class Solution0 {
    int[] nums;
    int target;
    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int i = dfs(true);
        int j = dfs(false) - 1;
        if (i <= j && j < nums.length &&
            nums[i] == target &&
            nums[j] == target
        ) {
            return new int[]{i, j};
        }
        return new int[]{-1, -1};
    }
    
    int dfs(boolean lower) {
        int i = 0, j = nums.length - 1, ans = nums.length;
        while (i <= j) {
            int k = i + ((j - i) >> 1);
            if (nums[k] > target || (lower && nums[k] >= target)) {
                j = k - 1;
                ans = k;
            } else {
                i = k + 1;
            }
        }
        return ans;
    }
}
