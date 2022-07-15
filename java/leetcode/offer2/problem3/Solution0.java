package leetcode.offer2.problem3;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            ans[i] = count(i);
        }
        return ans;
    }
    int count(int n) {
        String nb = Integer.toBinaryString(n);
        int ans = 0;
        for (char c : nb.toCharArray()) {
            ans += c == '0' ? 0 : 1;
        }
        return ans;
    }
}
