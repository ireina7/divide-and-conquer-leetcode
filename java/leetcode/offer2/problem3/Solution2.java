package leetcode.offer2.problem3;

public class Solution2 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    @Override
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
