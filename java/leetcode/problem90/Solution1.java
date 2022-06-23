package leetcode.problem90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 extends Solution {
    int[] nums;
    List<List<Integer>> ans;
    LinkedList<Integer> cur;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.ans = new ArrayList<>();
        this.cur = new LinkedList<>();
        dfs(0);
        return ans;
    }
    
    private void dfs(int i) {
        ans.add(new ArrayList<>(cur));
        for (int j = i; j < nums.length; ++j) {
            if (j > i && nums[j] == nums[j - 1]) continue;
            cur.add(nums[j]);
            dfs(j + 1);
            cur.removeLast();
        }
    }
    
    @Override
    public String describe() {
        return "Backtracking, evil";
    }
}
