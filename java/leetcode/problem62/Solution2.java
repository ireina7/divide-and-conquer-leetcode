package leetcode.problem62;

public class Solution2 extends Solution {
    @Override
    public String describe() {
        return "Math";
    }
    
    @Override
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
