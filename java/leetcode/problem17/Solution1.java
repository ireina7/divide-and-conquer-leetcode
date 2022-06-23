package leetcode.problem17;

import core.Solution;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution1 implements Solution {
    Map<Character, String> mem = Map.of(
        '1', "",
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );
    List<String> ans;
    LinkedList<Character> cur;
    char[] ds;
    public List<String> letterCombinations(String digits) {
        this.ans = new ArrayList<>();
        this.cur = new LinkedList<>();
        this.ds = digits.toCharArray();
        if (digits.isEmpty()) return List.of();
        dfs(0);
        return ans;
    }
    void dfs(int i) {
        if (i == ds.length) {
            StringBuilder sb = new StringBuilder();
            for (var c : cur) sb.append(c);
            ans.add(sb.toString());
            return;
        }
        if (!mem.containsKey(ds[i])) return;
        String cs = mem.get(ds[i]);
        for (char c : cs.toCharArray()) {
            cur.add(c);
            dfs(i + 1);
            cur.removeLast();
        }
    }
    
    @Override
    public String describe() {
        return "Backtracking";
    }
    
    @Override
    public URL link() throws MalformedURLException {
        return new URL("https://leetcode.cn/problems/letter-combinations-of-a-phone-number/");
    }
}
