package leetcode.problem69;
import java.util.*;

public class Solution0 {
    int target;
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x == 1) return 1;
        this.target = x;
        return dfs(x / 2);
    }
    int dfs(int n) {
        if(n == target / n) {
            return n;
        }
        if(n < target / n) {
            return dfs(n + 1);
        }
        if((n - 1) < target / (n - 1)) {
            return n - 1;
        }
        return dfs(n / 2);
    }
}
