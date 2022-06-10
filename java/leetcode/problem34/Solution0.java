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
        return dfs(0, nums.length - 1);
    }
    int[] dfs(int i, int j) {
        return null;
    }
}
