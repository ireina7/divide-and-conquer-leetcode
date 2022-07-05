package leetcode.problem70;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    @Override
    public int climbStairs(int n) {
        if (n == 0) return 0;
        int n1 = 1, n2 = 1;
        for (int i = 2; i <= n; ++i) {
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n2;
    }
}
