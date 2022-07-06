package leetcode.problem96;

public class Solution1 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    @Override
    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; ++i) {
            int ans = 0;
            for (int j = 0; j < i; ++j) {
                ans += memo[j] * memo[i - j - 1];
            }
            memo[i] = ans;
        }
        return memo[n];
    }
}
