package leetcode.problem541;

public class Solution0 {
    char[] cs;
    int k;
    public String reverseStr(String s, int k) {
        this.cs = s.toCharArray();
        this.k = k;
        dfs(0);
        return new String(cs);
    }
    private void dfs(int i) {
        if(cs.length - i <= k) {
            reverse(i, cs.length - 1);
            return;
        }
        reverse(i, i + k - 1);
        dfs(i + 2 * k);
    }
    private void reverse(int i, int j) {
        while(i < j) {
            char c = cs[i];
            cs[i] = cs[j];
            cs[j] = c;
            ++i; --j;
        }
    }
}
