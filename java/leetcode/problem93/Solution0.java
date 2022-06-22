package leetcode.problem93;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/restore-ip-addresses/
 * */
public class Solution0 {
    String s;
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        return dfs(0, 4);
    }
    List<String> dfs(int i, int k) {
        List<String> ans = new ArrayList<>();
        if (i == s.length() && k == 0) {
            ans.add("");
            return ans;
        }
        if (i >= s.length() || k <= 0) return ans;
        var rests = dfs(i + 1, k - 1);
        for (var ss : rests) {
            ans.add(String.format("%s%s%s", s.charAt(i), ss.isEmpty() ? "" : ".", ss));
        }
        if (s.charAt(i) == '0') return ans;
        
        if (i + 1 < s.length()) {
            var rest = dfs(i + 2, k - 1);
            for (var ss : rest) {
                ans.add(String.format("%s%s%s", s.substring(i, i + 2), ss.isEmpty() ? "" : ".", ss));
            }
        }
        if (i + 2 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 3));
            if (num > 255) return ans;
            var rest = dfs(i + 3, k - 1);
            for (var ss : rest) {
                ans.add(String.format("%s%s%s", num, ss.isEmpty() ? "" : ".", ss));
            }
        }
        return ans;
    }
}
