package leetcode.problem96;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Naive recursion";
    }
    
    @Override
    public int numTrees(int n) {
        if (n <= 1) return 1;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += numTrees(i) * numTrees(n - i - 1);
        }
        return 0;
    }
}
