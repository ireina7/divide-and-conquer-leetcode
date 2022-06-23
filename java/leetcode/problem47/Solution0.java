package leetcode.problem47;

import java.util.*;

public class Solution0 extends Solution {
    LinkedList<Integer> nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = new LinkedList<>();
        for (int i : nums) this.nums.add(i);
        return dfs(this.nums);
    }
    
    private List<List<Integer>> dfs(LinkedList<Integer> nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.isEmpty()) {
            ans.add(new ArrayList<>());
            return ans;
        }
        Set<Integer> memo = new HashSet<>();
        for (int i = 0; i < nums.size(); ++i) {
            int x = nums.get(i);
            if (memo.contains(x)) continue;
            memo.add(x);
            var set = new LinkedList<>(nums);
            set.remove(i);
            var rest = dfs(set);
            for (var xs : rest) {
                xs.add(0, x);
                ans.add(xs);
            }
        }
        return ans;
    }
    
    @Override
    public String describe() {
        return "Naive recursion";
    }
}
