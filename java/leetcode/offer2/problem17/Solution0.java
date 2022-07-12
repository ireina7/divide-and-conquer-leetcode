package leetcode.offer2.problem17;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        String ans = "";
        int[] ss = new int[256];
        int[] ts = new int[256];
        for (char c : t.toCharArray()) {
            ts[c] += 1;
        }
        int i = 0, j = 0;
        for (; j < s.length(); ++j) {
            ss[s.charAt(j)] += 1;
            if (check(ss, ts)) {
                if (ans == "" || j - i + 1 < ans.length()) {
                    ans = s.substring(i, j + 1);
                }
                while (i <= j && check(ss, ts)) {
                    ss[s.charAt(i)] -= 1;
                    i += 1;
                }
                if (ans == "" || j - i + 2 < ans.length()) {
                    ans = s.substring(i - 1, j + 1);
                }
            }
        }
        return ans;
    }
    boolean check(int[] s, int[] t) {
        if (s.length < 256 || t.length < 256) return false;
        for (int i = 0; i < 256; ++i) {
            if (s[i] < t[i]) return false;
        }
        return true;
    }
}
