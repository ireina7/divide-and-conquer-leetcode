package leetcode.problem242;

public class Solution0 {
    public boolean isAnagram(String s, String t) {
        int[] memo = new int[26];
        for (char c : s.toCharArray()) memo[c - 'a'] += 1;
        for (char c : t.toCharArray()) memo[c - 'a'] -= 1;
        for (int i : memo) {
            if (i != 0) return false;
        }
        return true;
    }
}
