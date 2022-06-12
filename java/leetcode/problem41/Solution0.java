package leetcode.problem41;
import java.util.*;

/**
 * @url https://leetcode.cn/problems/first-missing-positive/
 * @constraints time O(n), space O(1)
 *
 * The constraints are too strict, although the overall strategy is `dac`
 * but the implementation has to be imperative.
 * */
public class Solution0 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}



