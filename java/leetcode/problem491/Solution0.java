package leetcode.problem491;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/increasing-subsequences/
 * */
public class Solution0 {
    int[] nums;
    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        List<List<Integer>> ans = new ArrayList<>();
        for (var xs : dfs(0)) {
            if (xs.size() <= 1) continue;
            ans.add(xs);
        }
        return ans;
    }
    List<List<Integer>> dfs(int i) {
        List<List<Integer>> ans = new ArrayList<>();
        if (i == nums.length) {
            ans.add(new ArrayList<>());
            return ans;
        }
        var rest = dfs(i + 1);
        for (List<Integer> xs : rest) {
            if (!(xs.size() > 0 && nums[i] == xs.get(0))) {
                ans.add(new ArrayList<>(xs));
            }
            if (xs.isEmpty() || nums[i] <= xs.get(0)) {
                xs.add(0, nums[i]);
                ans.add(xs);
            }
        }
        return ans;
    }
}
