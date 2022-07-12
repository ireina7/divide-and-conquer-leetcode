package leetcode.offer2.problem18;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public boolean isPalindrome(String s) {
        int[] cs = s.toLowerCase().chars()
            .filter(c -> c >= 'a' && c <= 'z' || c >= '0' && c <= '9')
            .toArray();
        int i = 0, j = cs.length - 1;
        while (i < j) {
            if (cs[i] != cs[j]) {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }
}
