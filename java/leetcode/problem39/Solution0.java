package leetcode.problem39;
import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/combination-sum/
 * */
public class Solution0 {
    int[] cands;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.cands = candidates;
        return dfs(0, target);
    }
    List<List<Integer>> dfs(int i, int target) {
        if(target == 0) {
            return List.of(new ArrayList<>());
        }
        if(target < 0 || i == cands.length) {
            return List.of();
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int j = 0; cands[i] * j <= target; ++j) {
            var rest = dfs(i + 1, target - cands[i] * j);
            for(int k = 0; k < rest.size(); ++k) {
                var xs = rest.get(k);
                for(int cnt = j; cnt > 0; --cnt) {
                    xs.add(0, cands[i]);
                }
                ans.add(xs);
            }
        }
        return ans;
    }
}
