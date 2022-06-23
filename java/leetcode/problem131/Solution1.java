package leetcode.problem131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/palindrome-partitioning/
 * 回溯再做一遍。。。
 * */
public class Solution1 {
    String s;
    List<List<String>> ans;
    LinkedList<String> cur;
    public List<List<String>> partition(String s) {
        this.s = s;
        this.ans = new ArrayList<>();
        this.cur = new LinkedList<>();
        dfs(0);
        return ans;
    }
    void dfs(int i) {
        if (i >= s.length()) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int j = i; j < s.length(); ++j) {
            if (isPalindrome(s, i, j)) {
                cur.add(s.substring(i, j + 1));
            } else continue;
            dfs(j + 1);
            cur.removeLast();
        }
    }
    //判断是否是回文串
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
