package leetcode.problem78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/
 * */
public class Solution2 extends Solution {
    int[] nums;
    LinkedList<Integer> cur;
    List<List<Integer>> ans;
    
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        this.cur = new LinkedList<>();
        this.ans = new ArrayList<>();
        dfs(0);
        return ans;
    }
    
    void dfs(int i) {
        ans.add(new ArrayList<>(cur));
        for (int j = i; j < nums.length; ++j) {
            cur.add(nums[j]);
            dfs(j + 1);
            cur.removeLast();
        }
    }
    
    @Override
    public String describe() {
        return "Yet another backtracking";
    }
}
