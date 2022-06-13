package leetcode.problem76;
import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/minimum-window-substring/
 * no time to implement real dac...
 * sliding windows can be simply translated to dac, It's your turn now.
 * */
public class Solution0 {
    public String minWindow(String s, String t) {
        char[] chars = s.toCharArray(), chart = t.toCharArray();
        int n = chars.length, m = chart.length;
        int[] hash = new int[128];
        for (char c : chart) hash[c]--;
        
        String res = "";
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            hash[chars[i]]++;
            if (hash[chars[i]] <= 0) cnt++;
            while (cnt == m && hash[chars[j]] > 0) hash[chars[j++]]--;
            if (cnt == m)
                if (res.equals("") || res.length() > i - j + 1)
                    res = s.substring(j, i + 1);
        }
        return res;
    }
}
