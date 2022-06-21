package leetcode.problem77;

import java.util.ArrayList;
import java.util.List;

public class Solution0 {
    int n;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        if (k <= 0) return List.of();
        return dfs(1, k);
    }
    /**
     * 真的需要用回溯法吗？
     * */
    List<List<Integer>> dfs(int i, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k == 0) {
            ans.add(new ArrayList<>());
            return ans;
        }
        // 剪枝小优化
        if (n - i + 1 == k) {
            List<Integer> cur = new ArrayList<>();
            for (int x = i; x <= n; ++x) cur.add(x);
            ans.add(cur);
            return ans;
        }
        for (int x = i; x <= n; ++x) {
            var rest = dfs(x + 1, k - 1);
            for (var xs : rest) xs.add(0, x);
            ans.addAll(rest);
        }
        return ans;
    }
}
