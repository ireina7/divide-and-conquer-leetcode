package leetcode.offer2.problem7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    int[] nums;
    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            var xs = twoSum(i + 1, nums.length - 1, 0 - nums[i]);
            for (var ys : xs) {
                ys.add(0, nums[i]);
            }
            ans.addAll(xs);
        }
        return ans;
    }
    List<List<Integer>> twoSum(int i, int j, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                List<Integer> cur = new ArrayList<>();
                cur.add(nums[i]);
                cur.add(nums[j]);
                ans.add(cur);
                i += 1;
                j -= 1;
                while (i < j && nums[i] == nums[i - 1]) i += 1;
                while (j > i && nums[j] == nums[j + 1]) j -= 1;
            } else if (sum < target) {
                i += 1;
                while (i < j && nums[i] == nums[i - 1]) i += 1;
            } else {
                j -= 1;
                while (j > i && nums[j] == nums[j + 1]) j -= 1;
            }
        }
        return ans;
    }
}
