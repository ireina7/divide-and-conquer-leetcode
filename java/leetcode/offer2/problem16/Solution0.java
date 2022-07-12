package leetcode.offer2.problem16;

import java.util.HashSet;
import java.util.Set;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int ans = 0;
        int i = 0, j = 0;
        Set<Character> mem = new HashSet<>();
        for (; j < s.length(); ++j) {
            if (mem.contains(s.charAt(j))) {
                while (i < j && s.charAt(i) != s.charAt(j)) {
                    mem.remove(s.charAt(i));
                    i += 1;
                }
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    mem.remove(s.charAt(i));
                    i += 1;
                }
            }
            mem.add(s.charAt(j));
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
