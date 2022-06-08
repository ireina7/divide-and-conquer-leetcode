package leetcode.problem28;
import java.util.*;

/**
 * https://leetcode.cn/problems/implement-strstr/
 * */
public class Solution0 {
    String s;
    String p;
    public int strStr(String haystack, String needle) {
        this.s = haystack;
        this.p = needle;
        return search();
    }
    int search() {
        int n = s.length(), m = p.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (s.charAt(i + j) != p.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
