package leetcode.problem40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    int[] cands;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.cands = candidates;
        return dfs(0, target);
    }
    List<List<Integer>> dfs(int i, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (target == 0) {
            ans.add(new ArrayList<>());
            return ans;
        }
        if (i >= cands.length) return ans;
        for (int j = i; j < cands.length; ++j) {
            if (j > i && cands[j] == cands[j - 1]) continue;
            if (target - cands[j] < 0) break;
            var rest = dfs(j + 1, target - cands[j]);
            for (var xs : rest) {
                xs.add(0, cands[j]);
                ans.add(xs);
            }
        }
        return ans;
    }
}
