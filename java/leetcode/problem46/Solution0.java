package leetcode.problem46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution0 extends Solution {
    LinkedList<Integer> nums;
    public List<List<Integer>> permute(int[] nums) {
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
        for (int i = 0; i < nums.size(); ++i) {
            var set = new LinkedList<>(nums);
            set.remove(i);
            var rest = dfs(set);
            for (var xs : rest) {
                xs.add(0, nums.get(i));
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
