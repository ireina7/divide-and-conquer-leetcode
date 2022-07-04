package leetcode.problem763;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution0 extends Solution {
    @Override
    public String describe() {
        return "Pure Divide and conquer!";
    }
    
    char[] s;
    int[] cs;
    @Override
    public List<Integer> partitionLabels(String s) {
        this.s = s.toCharArray();
        this.cs = new int[26];
        Arrays.fill(cs, -1);
        return dfs(s.length() - 1).stream()
            .map(p -> p[1] - p[0] + 1)
            .collect(Collectors.toList());
    }
    List<int[]> dfs(int i) {
        if (i < 0) {
            return new ArrayList<>();
        }
        var rest = dfs(i - 1);
        char c = s[i];
        int j = cs[c - 'a'];
        if (j == -1) {
            cs[c - 'a'] = i;
            rest.add(new int[]{i, i});
            return rest;
        }
        List<int[]> ans = new ArrayList<>();
        for (int[] ints : rest) {
            if (ints[1] < j) {
                ans.add(ints);
                continue;
            }
            ans.add(new int[]{ints[0], i});
            break;
        }
        return ans;
    }
}
