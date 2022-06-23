package leetcode.problem216;

import core.Solution;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution0 implements Solution {
    LinkedList<Integer> path;
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.path = new LinkedList<>();
        this.ans = new ArrayList<>();
        dfs(1, k, n);
        return ans;
    }
    void dfs(int i, int k, int n) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (i >= 10 || k < 0 || n < 0) return;
        for (int j = i; j < 10; ++j) {
            path.add(j);
            dfs(j + 1, k - 1, n - j);
            path.removeLast();
        }
    }
    
    @Override
    public String describe() {
        return "Back tracking";
    }
    
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/combination-sum-iii/");
    }
}
