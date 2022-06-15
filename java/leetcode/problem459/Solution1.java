package leetcode.problem459;

public class Solution1 {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s)
            .substring(1, s.length() * 2 - 1)
            .contains(s);
    }
}
