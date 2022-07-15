package leetcode.offer2.problem57;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    int[] nums;
    @Override
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> mem = new TreeSet<>();
        for (int j = 0; j < nums.length; ++j) {
            if (j <= k) {
                Integer lower = mem.ceiling(nums[j] - t);
                Integer higher = mem.floor(nums[j] + t);
                if (lower != null && lower <= (long)nums[j] + t) {
                    return true;
                }
                if (higher != null && higher >= (long)nums[j] - t) {
                    return true;
                }
            } else {
                mem.remove(nums[j - k - 1]);
                Integer lower = mem.ceiling(nums[j] - t);
                Integer higher = mem.floor(nums[j] + t);
                if (lower != null && lower <= (long)nums[j] + t) {
                    return true;
                }
                if (higher != null && higher >= (long)nums[j] - t) {
                    return true;
                }
                mem.add(nums[j]);
            }
        }
        return false;
    }
}
