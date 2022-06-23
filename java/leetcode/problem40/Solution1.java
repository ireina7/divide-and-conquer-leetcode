package leetcode.problem40;
import core.Solution;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Solution1 implements Solution {
    int[] cands;
    List<List<Integer>> ans;
    LinkedList<Integer> cur;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.cands = candidates;
        this.ans = new ArrayList<>();
        this.cur = new LinkedList<>();
        dfs(0, target);
        return ans;
    }
    void dfs(int i, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if (i >= cands.length) return;
        for (int j = i; j < cands.length; ++j) {
            if (j > i && cands[j] == cands[j - 1]) continue;
            if (target < cands[j]) break;
            cur.add(cands[j]);
            dfs(j + 1, target - cands[j]);
            cur.removeLast();
        }
    }
    
    @Override
    public String describe() {
        return "Backtracking";
    }
    
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/combination-sum-ii/");
    }
}