package leetcode.problem459;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    char[] cs;
    Map<Integer, Integer> memo;
    public boolean repeatedSubstringPattern(String s) {
        this.cs = s.toCharArray();
        this.memo = new HashMap<>();
        return dfs(0) != cs.length;
    }
    int dfs(int i) {
        if(i == cs.length) return 0;
        if(memo.containsKey(i)) return memo.get(i);
        
        int sep = (cs.length - i) / 2;
        for(int d = 1; d <= sep; ++d) {
            if((cs.length - i - d) % d != 0) continue;
            int dd = dfs(i + d);
            boolean rest = dd == d;
            if((d < sep && !rest) || (!rest && (cs.length - i) % 2 != 0)) continue;
            boolean ok = true;
            for(int j = i; j < i + d; ++j) {
                if(cs[j] != cs[j + d]) {
                    ok = false;
                    break;
                }
            }
            if(ok) {
                memo.put(i, d);
                return d;
            }
        }
        memo.put(i, cs.length - i);
        return cs.length - i;
    }
}
