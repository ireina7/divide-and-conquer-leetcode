package leetcode.problem445;

import java.util.Arrays;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    int[] child;
    int[] cookie;
    @Override
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        this.child = g;
        this.cookie = s;
        return dfs(0, 0);
    }
    int dfs(int i, int j) {
        if (i == child.length || j == cookie.length) {
            return 0;
        }
        return cookie[j] >= child[i]
            ? 1 + dfs(i + 1, j + 1) : dfs(i, j + 1);
    }
}
