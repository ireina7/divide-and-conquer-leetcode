package leetcode.problem28;
import java.util.*;

/**
 * KMP is just an application of dynamic programming.
 * */
public class Solution1 {
    String s;
    String p;
    int m;
    int n;
    public int strStr(String haystack, String needle) {
        this.s = haystack;
        this.p = needle;
        this.n = s.length();
        this.m = p.length();
        return search(nexts(p));
    }
    int[] nexts(String p) {
        int[] ans = new int[p.length()];
        for(int i = 0; i < ans.length; ++i) {
            ans[i] = next(i);
        }
        return ans;
    }
    /**
     * Get next array values
     *
     * Apparently we can cache the next array to gain better performance,
     * But I'm lazy and this is not the important part,
     * Someone will implement this for us.
     * */
    int next(int i) {
        if(i == 0) {
            return 0;
        }
        int j = next(i - 1);
        if(p.charAt(j) == p.charAt(i)) {
            return j + 1;
        }
        while (j > 0) {
            j = next(j - 1); // dynamic hole!
            if(p.charAt(j) == p.charAt(i)) {
                return j + 1;
            }
        }
        return 0;
    }
    int search(int[] next) {
        for (int i = 0, j = 0; i < n; i++) {
            // not match
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }
            //match
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            // found
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}
