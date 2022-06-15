package leetcode.problem383;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution0 {
    char[] note;
    char[] dict;
    Map<Character, Integer> memo;
    public boolean canConstruct(String ransomNote, String magazine) {
        this.note = ransomNote.toCharArray();
        this.dict = magazine.toCharArray();
        this.memo = new HashMap<>();
        for(char c : dict) {
            memo.put(c, memo.getOrDefault(c, 0) + 1);
        }
        return dfs(0);
    }
    boolean dfs(int i) {
        if(i == note.length) {
            return true;
        }
        char c = note[i];
        if(memo.containsKey(c)) {
            if(memo.get(c) == 0) {
                memo.remove(c);
                return false;
            }
            memo.put(c, memo.get(c) - 1);
            return dfs(i + 1);
        }
        return false;
    }
}
