package leetcode.problem738;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Greedy";
    }
    
    @Override
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        char[] cs = s.toCharArray();
        int start = s.length();
        for (int i = len - 2; i >= 0; --i) {
            if (cs[i] > cs[i + 1]) {
                cs[i]--;
                start = i + 1;
            }
        }
        for (int i = start; i < len; i++) {
            cs[i] = '9';
        }
        return Integer.parseInt(String.valueOf(cs));
    }
}
