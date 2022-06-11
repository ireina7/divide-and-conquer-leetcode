package leetcode.problem40;
import java.util.*;

public class Solution1 {
    int[] cands;
    List<List<Integer>> ans;
    List<Integer> selected;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.cands = candidates;
        this.ans = new ArrayList<>();
        this.selected = new ArrayList();
        dfs(-1, target);
        return ans;
    }
    void dfs(int index, int target) {
        if (target == 0) {
            ans.add(new ArrayList(selected));
            return;
        }
        for (int i = index + 1; i < cands.length; ++i) {
            if (target - cands[i] < 0) return;
            if (i != index + 1 && cands[i] == cands[i - 1]) continue;
            selected.add(cands[i]);
            dfs(i, target - cands[i]);
            selected.remove(selected.size() - 1);
        }
    }
}
