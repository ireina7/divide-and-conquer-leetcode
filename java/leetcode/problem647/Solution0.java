package leetcode.problem647;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    char[] s;
    int ans = 0;
    @Override
    public int countSubstrings(String s) {
        this.s = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            check(i, i);
            check(i, i + 1);
        }
        return ans;
    }
    void check(int i, int j) {
        while (i >= 0 && j < s.length) {
            if (s[i] != s[j]) return;
            i--;
            j++;
            ans++;
        }
    }
}
