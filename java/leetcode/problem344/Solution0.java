package leetcode.problem344;

/**
 * https://leetcode.cn/problems/reverse-string/
 * */
public class Solution0 {
    char[] s;
    public void reverseString(char[] s) {
        this.s = s;
        dfs(0);
    }
    void dfs(int i) {
        if(i == s.length) return;
        char c = s[i];
        dfs(i + 1);
        int j = s.length - i - 1;
        s[j] = c;
    }
}
