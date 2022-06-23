package leetcode.problem77;

import core.Solution;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1 implements Solution {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k);
        return ans;
    }
    /**
     * 好吧，这里加上回溯写法。
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围。
     * @param j 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,j] ）
     */
    void dfs(int j, int k) {
        if (k == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (j == 0) return;
        for (int i = k; i <= j; ++i) {
            path.add(i);
            dfs(i - 1, k - 1);
            path.removeLast();
        }
    }
    
    @Override
    public String describe() {
        return "回溯解法";
    }
    
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/combinations/");
    }
}