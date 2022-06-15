package leetcode.problem459;

public class Solution2 {
    char[] cs;
    public boolean repeatedSubstringPattern(String s) {
        this.cs = s.toCharArray();
        return dfs(1);
    }
    boolean dfs(int d) {
        if(d > cs.length / 2) return false;
        if(cs.length % d != 0) return dfs(d + 1);
        for(int j = d; j < cs.length; ++j) {
            if (cs[j] != cs[j - d]) return dfs(d + 1);
        }
        return true;
    }
}
