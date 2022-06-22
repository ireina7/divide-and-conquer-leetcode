package leetcode.problem131;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/palindrome-partitioning/
 * */
public class Solution0 {
    String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        return dfs(0);
    }
    List<List<String>> dfs(int i) {
        List<List<String>> ans = new ArrayList<>();
        if (i == s.length()) {
            ans.add(new ArrayList<>());
            return ans;
        }
        char c = s.charAt(i);
        var rest = dfs(i + 1);
        for (var xs : rest) {
            var ys = new ArrayList<>(xs);
            ys.add(0, String.valueOf(c));
            ans.add(ys);
            
            if (xs.size() == 0) continue;
            if (xs.get(0).equals(String.valueOf(c))) {
                var zs = new ArrayList<>(xs);
                zs.set(0, String.format("%s%s", c, c));
                ans.add(zs);
            }
            int len = xs.get(0).length();
            if (i + len + 1 < s.length() && s.charAt(i + len + 1) == c && xs.get(1).length() == 1) {
                var zs = new ArrayList<>(xs);
                String end = xs.get(1);
                zs.remove(1);
                zs.set(0, String.format("%s%s%s", c, xs.get(0), end));
                ans.add(zs);
            }
        }
        return ans;
    }
}
