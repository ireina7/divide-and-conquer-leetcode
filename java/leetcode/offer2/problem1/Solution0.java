package leetcode.offer2.problem1;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        if (a == 0) return 0;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        a = -Math.abs(a);
        b = -Math.abs(b);
        if (a > b) return 0;
        int ans = 0;
        for (int i = 0; i < 31; ++i) {
            if ((b << i) >= 0 || a - (b << i) > 0) break;
            a -= b << i;
            ans += (1 << i);
        }
        int rest = divide(a, b);
        return sign < 0 ? -(ans + rest) : (ans + rest);
    }
}
