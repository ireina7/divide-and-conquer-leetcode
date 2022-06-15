package leetcode.problem202;

import java.util.HashSet;
import java.util.Set;

public class Solution0 {
    Set<Integer> memo = new HashSet<>();
    public boolean isHappy(int n) {
        if(n == 1) return true;
        if(memo.contains(n)) return false;
        memo.add(n);
        return isHappy(getNextNumber(n));
    }
    private int getNextNumber(int n) {
        int ans = 0;
        while (n > 0) {
            int x = n % 10;
            ans += x * x;
            n = n / 10;
        }
        return ans;
    }
}
