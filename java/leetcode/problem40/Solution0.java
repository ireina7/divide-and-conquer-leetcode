package leetcode.problem40;
import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/combination-sum-ii/
 * */
public class Solution0 {
    int[] cands;
    Map<String, List<List<Integer>>> memo = new HashMap<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.cands = candidates;
        return dfs(0, target);
    }
    List<List<Integer>> dfs(int i, int target) {
        if(target == 0) {
            return List.of(new ArrayList<>());
        }
        if(target < 0 || i == cands.length || cands[i] > target) {
            return List.of();
        }
        String key = String.format("%d, %d", i, target); // evil, dirty, dying, fuck java's comparing!
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        Set<List<Integer>> ans = new HashSet<>();
        var withI = dfs(i + 1, target - cands[i]);
        var withoutI = dfs(i + 1, target);
        withI.forEach(xs -> {
            xs.add(0, cands[i]);
            ans.add(xs);
        });
        withoutI.forEach(xs -> {
            ans.add(xs);
        });
        List<List<Integer>> ss = new ArrayList<>();
        for(var xs : ans) {
            ss.add(new ArrayList<Integer>(xs));
        }
        memo.put(key, ss);
        return ans.stream().collect(Collectors.toList());
    }
}
