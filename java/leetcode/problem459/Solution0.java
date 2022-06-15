package leetcode.problem459;

public class Solution0 {
    char[] cs;
    public boolean repeatedSubstringPattern(String s) {
        this.cs = s.toCharArray();
        int n = cs.length;
        for (int i = 1; i <= n / 2; ++i) {
            if(n % i != 0) continue;
            boolean match = true;
            for (int j = i; j < n; ++j) {
                if (cs[j] != cs[j - i]) {
                    match = false;
                    break;
                }
            }
            if (match) return true;
        }
        return false;
    }
}
