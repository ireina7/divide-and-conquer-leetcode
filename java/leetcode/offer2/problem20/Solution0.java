package leetcode.offer2.problem20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Dynamic programming";
    }
    
    @Override
    public int countSubstrings(String s) {
        Map<Character, List<Integer>> pos = new HashMap<>();
        boolean[][] mem = new boolean[s.length()][s.length()];
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            mem[i][i] = true;
            ans += 1;
            if (pos.containsKey(s.charAt(i))) {
                List<Integer> ps = pos.get(s.charAt(i));
                for (int k : ps) {
                    if (k + 1 == i || k + 1 <= i - 1 && mem[k + 1][i - 1]) {
                        ans += 1;
                        mem[k][i] = true;
                    }
                }
                ps.add(i);
            } else {
                List<Integer> cur = new ArrayList<>();
                cur.add(i);
                pos.put(s.charAt(i), cur);
            }
        }
        return ans;
    }
}
