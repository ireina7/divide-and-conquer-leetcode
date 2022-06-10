package leetcode.problem10;

public class Solution0 {
  String s;
  String p;
  public boolean isMatch(String s, String p) {
    this.s = s;
    this.p = p;
    return match(0, 0);
  }
  boolean match(int i, int j) {
    if(i == s.length()) {
      if(j == p.length()) return true;
      if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
        return match(i, j + 2);
      }
      return false;
    }
    if(j == p.length()) return false;
    boolean ans = false;
    if(j + 1 < p.length() && p.charAt(j + 1) == '*') {
      ans = s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'
          ? match(i + 1, j + 2) || match(i + 1, j) || match(i, j + 2)
          : match(i, j + 2);
    } else if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
      ans = match(i + 1, j + 1);
    } else {
      ans = false;
    }
    return ans;
  }
}
