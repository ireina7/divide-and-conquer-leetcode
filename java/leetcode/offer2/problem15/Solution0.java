package leetcode.offer2.problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return null;
    }
    
    @Override
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return List.of();
        }
        List<Integer> ans = new ArrayList<>();
        int[] ps = new int[26];
        for (char c : p.toCharArray()) {
            ps[c - 'a'] += 1;
        }
        int[] ss = new int[26];
        for (int i = 0; i < p.length() - 1; ++i) {
            ss[s.charAt(i) - 'a'] += 1;
        }
        int i = 0, j = p.length() - 1;
        for (; j < s.length(); ++i, ++j) {
            ss[s.charAt(j) - 'a'] += 1;
            if (Arrays.equals(ps, ss)) {
                ans.add(i);
            }
            ss[s.charAt(i) - 'a'] -= 1;
        }
        return ans;
    }
}
