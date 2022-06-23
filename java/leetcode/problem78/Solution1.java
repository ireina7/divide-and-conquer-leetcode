package leetcode.problem78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/subsets/
 * */
public class Solution1 extends Solution {
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
        if (i >= nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        dfs(i + 1);
        cur.add(nums[i]);
        dfs(i + 1);
        cur.removeLast();
    }
    
    @Override
    public String describe() {
        return "Most concise backtracking";
    }
}
