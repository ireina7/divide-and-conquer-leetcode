package leetcode.problem90;

import java.util.*;

/**
 * https://leetcode.cn/problems/subsets-ii/
 * */
public class Solution0 {
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        return dfs(0);
    }
    List<List<Integer>> dfs(int i) {
        List<List<Integer>> ans = new ArrayList<>();
        if (i == nums.length) {
            ans.add(new ArrayList<>());
            return ans;
        }
        var rest = dfs(i + 1);
        for (var xs : rest) {
            if (!(xs.size() > 0 && nums[i] == xs.get(0))) {
                ans.add(new ArrayList<>(xs));
            }
            xs.add(0, nums[i]);
            ans.add(xs);
        }
        return ans;
    }
}
