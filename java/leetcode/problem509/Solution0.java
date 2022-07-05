package leetcode.problem509;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    @Override
    public int fib(int n) {
        if (n == 1) return 0;
        int a = 0, b = 1;
        for (int i = 2; i <= n; ++i) {
            int c = b;
            b = a + b;
            a = c;
        }
        return b;
    }
}
