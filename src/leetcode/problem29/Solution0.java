package leetcode.problem29;
import java.util.*;

/**
 * https://leetcode.cn/problems/divide-two-integers/
 * */
public class Solution0 {
    int ans = 1;
    int divisor;
    public int divide(int a, int b) {
        this.divisor = Math.abs(b);
        if(Integer.valueOf(a) == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        if(b == 1) return a;
        if(b == -1) return -a;
        if(b == 0) return 0;
        boolean neg =
            (a >= 0 || b >= 0) && (a < 0 || b < 0);
        long x = Math.abs((long)a);
        long y = Math.abs((long)b);
        if(x < y) return 0;
        return neg ? -dfs(x, y) : dfs(x, y);
    }
    int dfs(long a, long b) {
        if(a <  b) {
            ans >>= 1;
            b >>= 1;
            while(a >= b) {
                b += divisor;
                ans += 1;
            }
            return ans - 1;
        }
        if(a == b) return ans;
        ans <<= 1;
        return dfs(a, b << 1);
    }
}
