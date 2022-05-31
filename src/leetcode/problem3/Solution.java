package leetcode.problem3;
import java.util.*;

class Solution {
    // To avoid passing memo around...
    Map<Character, Integer> memo = new HashMap<>();
    int max = 0;
    
    /**
    Type 0 divide
     */
    int dfs(char[] cs, int i) {
        if(i == cs.length) {
            return 0;
        }
        int ans = 0;
        char c = cs[i];
        int rest = dfs(cs, i + 1);
        if(memo.containsKey(c)) {
            int j = memo.get(c);
            memo.values().removeIf(v -> v >= j);
            memo.put(c, i);
            ans = j - i;
        } else {
            memo.put(c, i);
            ans = rest + 1;
        }
        max = Math.max(ans, max);
        return ans;
    }
    public int lengthOfLongestSubstring(String s) {
        dfs(s.toCharArray(), 0);
        return max;
    }
}