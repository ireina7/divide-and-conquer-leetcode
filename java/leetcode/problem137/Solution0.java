package leetcode.problem137;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public int singleNumber(int[] nums) {
        int[] mem = new int[32];
        for (int n : nums) {
            for (int i = 0; i < 32; ++i) {
                int bit = (n & (1 << i)) == 0 ? 0 : 1;
                mem[i] += bit;
            }
        }
        int ans = 0;
        for (int i = 0; i < 31; ++i) {
            mem[i] = mem[i] % 3;
            ans += mem[i] * Math.pow(2, i);
        }
        ans -= (mem[31] % 3) * Math.pow(2, 31);
        return ans;
    }
}
