package leetcode.problem39;

import core.Solution;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum/
 * 用回溯法再做一遍。。。
 * */
public class Solution1 implements Solution {
    List<List<Integer>> ans;
    List<Integer> path;
    int[] cands;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.ans = new ArrayList<>();
        this.path = new ArrayList<>();
        Arrays.sort(candidates);
        this.cands = candidates;
        dfs(0, target);
        return ans;
    }
    void dfs(int i, int target) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < cands.length; ++j) {
            if (target - cands[j] < 0) break;
            path.add(cands[j]);
            dfs(j, target - cands[j]);
            path.remove(path.size() - 1);
        }
    }
    
    @Override
    public String describe() {
        return "Backtracking";
    }
    
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/combination-sum/");
    }
}
