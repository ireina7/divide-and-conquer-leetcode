package leetcode.problem216;

import java.util.ArrayList;
import java.util.List;

public class Solution0 {
    List<Integer> path;
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.path = new ArrayList<>();
        this.ans = new ArrayList<>();
        dfs(1, k, n);
        return ans;
    }
    void dfs(int i, int k, int n) {
        if (k == 0 && n == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (k <= 0 || n <= 0 || i >= 10) return;
        for (int j = i; j <= 10 - k; ++j) {
            path.add(j);
            dfs(j + 1, k - 1, n - j);
            path.remove(path.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        Solution0 solution = new Solution0();
        var ans = solution.combinationSum3(k, n);
        System.out.printf("size: %d\n", ans.size());
        ans.forEach(xs -> {
            xs.forEach(x -> System.out.printf("%d, ", x));
            System.out.println();
        });
    }
}
