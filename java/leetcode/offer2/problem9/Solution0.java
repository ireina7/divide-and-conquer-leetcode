package leetcode.offer2.problem9;

import java.util.ArrayList;
import java.util.List;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    // Isomorphism of the recursion version
    @Override
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int ans = 0;
        int product = 1;
        int i = 0, j = 0;
        for (; j < nums.length; ++j) {
            product *= nums[j];
            while (i < j && product >= k) {
                product /= nums[i];
                i += 1;
            }
            if (product < k) ans += j - i + 1;
        }
        return ans;
    }
    
    int[] nums;
    int k;
    public int numSubarrayProductLessThanKRecur(int[] nums, int k) {
        int ans = 0;
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            List<Integer> next = new ArrayList<>();
            if (nums[i] < k) {
                next.add(nums[i]);
                ans += 1;
            }
            for (int prod : pre) {
                if (prod * nums[i] < k) {
                    next.add(prod * nums[i]);
                    ans += 1;
                }
            }
            pre = next;
        }
        return 0;
    }
}
