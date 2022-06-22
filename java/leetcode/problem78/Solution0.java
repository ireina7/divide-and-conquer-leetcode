package leetcode.problem78;

import java.util.ArrayList;
import java.util.List;

public class Solution0 {
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
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
            ans.add(new ArrayList<>(xs));
            xs.add(0, nums[i]);
            ans.add(new ArrayList<>(xs));
        }
        return ans;
    }
}
