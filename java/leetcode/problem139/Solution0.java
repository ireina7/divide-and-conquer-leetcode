package leetcode.problem139;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Memorized recursion";
    }
    
    Set<String> dict;
    String s;
    @Override
    public boolean wordBreak(String s, List<String> wordDict) {
        this.dict = wordDict.stream().collect(Collectors.toSet());
        this.s = s;
        return dfs(0);
    }
    Map<Integer, Boolean> memo = new HashMap<>();
    boolean dfs(int i) {
        if (i == s.length()) return true;
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        for (int j = i; j < s.length(); ++j) {
            if (dict.contains(s.substring(i, j + 1))) {
                if (dfs(j + 1)) {
                    memo.put(i, true);
                    return true;
                }
            }
        }
        memo.put(i, false);
        return false;
    }
}
