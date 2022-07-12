package leetcode.offer2.problem19;

import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    char[] cs;
    @Override
    public boolean validPalindrome(String s) {
        this.cs = s.toCharArray();
        return dfs(0, cs.length - 1, 1);
    }
    boolean dfs(int i, int j, int rest) {
        if (i >= j) return true;
        return cs[i] == cs[j]
            ? dfs(i + 1, j - 1, rest)
            : rest != 0 && (dfs(i + 1, j, rest - 1) || dfs(i, j - 1, rest - 1));
    }
}
